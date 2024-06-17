package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 반복수열
 */
public class _2331 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), p = nextInt(), count = 0;
    Map<Integer, Integer> numbers = new HashMap<>();

    while (numbers.getOrDefault(n, 0) < 2) {
      numbers.put(n, numbers.getOrDefault(n, 0) + 1);

      int sum = 0;
      while (n > 0) {
        sum += (int) Math.pow(n % 10, p);
        n /= 10;
      }
      n = sum;
    }

    for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
      if (entry.getValue() == 1) {
        ++count;
      }
    }
    System.out.println(count);
  }
}

/*
time complexity
O(N)

critical point
각 자릿수의 합

reference
https://www.acmicpc.net/problem/2331
*/
