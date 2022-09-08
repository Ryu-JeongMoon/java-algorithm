package algorithm.baekjoon.math_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 손익분기점
 */
public class _1712 {

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    int a = Integer.parseInt(s[0]);
    int b = Integer.parseInt(s[1]);
    int c = Integer.parseInt(s[2]);

    int breakEvenPoint = a / (c - b);
    if (breakEvenPoint < 0) {
      System.out.println(-1);
      return;
    }
    System.out.println(breakEvenPoint + 1);
  }
}
