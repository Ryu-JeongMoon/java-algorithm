package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 동전 게임
 */
public class _2684 {

  private static final Map<String, Integer> COINS_AND_INDEX = new ConcurrentHashMap<String, Integer>() {{
    put("TTT", 0);
    put("TTH", 1);
    put("THT", 2);
    put("THH", 3);
    put("HTT", 4);
    put("HTH", 5);
    put("HHT", 6);
    put("HHH", 7);
  }};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] theNumberOfCoins;
    StringBuilder sb = new StringBuilder();
    while (--n >= 0) {
      theNumberOfCoins = new int[8];
      String line = br.readLine();
      for (int i = 0; i < line.length() - 2; i++) {
        ++theNumberOfCoins[COINS_AND_INDEX.get(line.substring(i, i + 3))];
      }
      for (int theNumberOfCoin : theNumberOfCoins) {
        sb.append(theNumberOfCoin).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}

/*
time complexity
입력값은 항상 길이가 40, 3-동전수열의 경우의 수는 8이므로 매 입력마다 48번 반복
O(1)

critical point
배열 대신 Map으로 처리하려면 매 입력마다 값을 모두 0으로 초기화해줘야 함
HashMap, ConcurrentHashMap은 순서 유지가 안 되므로 LinkedHashMap 사용
입력 마다 0 할당 오버헤드가 있으니 배열 사용하는게 좋다!

reference
https://www.acmicpc.net/problem/2684
 */