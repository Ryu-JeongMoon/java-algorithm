package algorithm.solvedac.silver_4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 카드
 */
public class _11652 {

  public static void main(String[] args) throws IOException {
    int n = (int) nextLong(), maxValue = 0;
    long max = 0;
    Map<Long, Integer> frequencies = new HashMap<>(n / 2);
    for (int i = 0; i < n; i++) {
      long current = nextLong();
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

  private static long nextLong() throws IOException {
    long sum = 0;
    boolean isNegative = false;
    while (true) {
      int input = System.in.read();
      if (input == '-') {
        isNegative = true;
      } else if (input == '\n' || input == ' ') {
        return isNegative ? -sum : sum;
      } else {
        sum = (sum * 10) + (input - '0');
      }
    }
  }

}

/*
5
1
2
1
2
1
-1

8
-999
-998
-991
-999
-913
123249248
123249248
123249248


time complexity

critical point

reference
https://www.acmicpc.net/problem/11652
*/
