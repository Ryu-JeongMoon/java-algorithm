package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3의 배수
 */
public class _1769 {

  public static void main(String[] args) throws IOException {
    String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
    int sum = input.length() != 1 ? 0 : Integer.parseInt(input), count = 0;
    while (input.length() != 1) {
      sum = 0;
      for (char c : input.toCharArray()) {
        sum += (c - '0');
      }
      ++count;
      input = String.valueOf(sum);
    }
    System.out.println(count);
    System.out.println(sum % 3 == 0 ? "YES" : "NO");
  }
}

/*
time complexity
O(1)

critical point
경계 조건 주의 (입력 값이 한 자리 수인 경우)

reference
https://www.acmicpc.net/problem/1769
*/
