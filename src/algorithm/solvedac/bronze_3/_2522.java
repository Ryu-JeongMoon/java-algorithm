package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 별 찍기 - 12
 */
public class _2522 {

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < (2 * n - 1); i++) {
      sb.append(" ".repeat(Math.max(0, Math.abs(n - i - 1))));
      sb.append("*".repeat(Math.max(0, n - Math.abs(n - i - 1))));
      sb.append("\n");
    }
    System.out.print(sb);
  }
}

/*
time complexity
입력값 마다 for-loop 돌려야 하므로 O(n)

critical point
n = 3일 때, n - Math.abs(n - i - 1)
0 -> 1
1 -> 2
2 -> 3
3 -> 2
4 -> 1
 */