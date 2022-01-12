package algorithm.baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 팩토리얼
 */
public class _10872 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] factorial = new int[13];
    Arrays.fill(factorial, 1);

    for (int i = 1; i < factorial.length; i++) {
      factorial[i] = factorial[i - 1] * i;
    }

    System.out.println(factorial[n]);
  }
}
