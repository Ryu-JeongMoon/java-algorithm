package algorithm.baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 제로
 */
public class _10773 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Deque<Integer> totalNumbers = new ArrayDeque<>(n);
    int sum = 0;

    while (n-- > 0) {
      int number = Integer.parseInt(br.readLine());
      if (number != 0 && !totalNumbers.isEmpty()) {
        sum -= totalNumbers.pollLast();
      } else {
        totalNumbers.addLast(number);
        sum += number;
      }
    }

    System.out.print(sum);
  }
}
