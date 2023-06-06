package algorithm.solvedac.sprout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 검증수
 */
public class _2475 {

  public static void main(String[] args) throws IOException {
    int sum = Arrays.stream(new BufferedReader(new InputStreamReader(System.in)).readLine().split(" "))
      .mapToInt(Integer::parseInt)
      .map(i -> i * i)
      .sum();
    System.out.println(sum % 10);
  }
}

/*
time complexity
O(n)

critical point

reference
https://www.acmicpc.net/problem/2475
*/
