package algorithm.solvedac.silver_5;

import static java.util.Comparator.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 경매
 */
public class _2238 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine().split(" ")[1]);

    Map<Integer, Integer> frequenciesOfPrice = new HashMap<>(n);
    String[] values = new String[n];
    int[] prices = new int[n];
    for (int i = 0; i < n; i++) {
      values[i] = br.readLine();
      prices[i] = Integer.parseInt(values[i].split(" ")[1]);
      frequenciesOfPrice.put(prices[i], frequenciesOfPrice.getOrDefault(prices[i], 0) + 1);
    }

    int price = getPriceByStream(frequenciesOfPrice);
    // int price = getPriceByForEach(frequenciesOfPrice);

    for (int i = 0; i < prices.length; i++) {
      if (price == prices[i]) {
        System.out.print(values[i]);
        return;
      }
    }
  }

  private static int getPriceByStream(Map<Integer, Integer> frequenciesOfPrice) {
    return frequenciesOfPrice.entrySet()
      .stream()
      .min(comparingInt((Map.Entry<Integer, Integer> o) -> o.getValue())
        .thenComparingInt(Map.Entry::getKey))
      .map(Map.Entry::getKey)
      .orElse(Integer.MIN_VALUE);
  }

  private static int getPriceByForEach(Map<Integer, Integer> frequenciesOfPrice) {
    int price = 0, minimumFrequency = Integer.MAX_VALUE;
    Set<Map.Entry<Integer, Integer>> entries = frequenciesOfPrice.entrySet();
    for (Map.Entry<Integer, Integer> entry : entries) {
      if (entry.getValue() < minimumFrequency) {
        minimumFrequency = entry.getValue();
        price = entry.getKey();
      } else if (entry.getValue() == minimumFrequency && entry.getKey() < price) {
        price = entry.getKey();
      }
    }
    return price;
  }
}

/*
time complexity
O(n)

critical point
<가격, 횟수> 횟수 정렬 필요
1. 횟수가 적은 놈
2. 1이 중복 된다면 다음은 가격 낮은 놈 중 첫번째

472ms -> for-each
664ms -> stream
704ms -> parallel stream

reference
https://www.acmicpc.net/problem/2238
*/
