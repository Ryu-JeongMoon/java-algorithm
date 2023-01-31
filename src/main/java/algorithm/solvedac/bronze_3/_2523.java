package algorithm.solvedac.bronze_3;

import java.io.IOException;
import java.util.Scanner;

/**
 * 별 찍기 - 13
 */
public class _2523 {

  public static void main(String[] args) throws IOException {
    int n = new Scanner(System.in).nextInt();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 2 * n - 1; i++) {
      sb.append("*".repeat(Math.max(0, n - Math.abs(n - 1 - i)))).append("\n");
    }
    System.out.println(sb);
  }
}

/*
time complexity
O(n)

critical point
n - Math.abs(n - 1 - i)

reference
https://www.acmicpc.net/problem/2523
 */
