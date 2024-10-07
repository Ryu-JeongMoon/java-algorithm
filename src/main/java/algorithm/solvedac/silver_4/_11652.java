package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextLongWithNegative;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 카드
 */
public class _11652 {

  public static void main(String[] args) throws IOException {
    int n = (int) nextLongWithNegative(), maxValue = 0;
    long max = 0;
    Map<Long, Integer> frequencies = HashMap.newHashMap(n / 2);
    for (int i = 0; i < n; i++) {
      long current = nextLongWithNegative();
      int value = frequencies.getOrDefault(current, 0);
      frequencies.put(current, value + 1);

      if (value + 1 > maxValue) {
        max = current;
        maxValue = value + 1;
      } else if (value + 1 == maxValue && current < max) {
        max = current;
      }
    }
    System.out.println(max);
  }
}

/*
time complexity
O(N)

critical point

reference
https://www.acmicpc.net/problem/11652
*/
