package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 모든 순열
 */
public class _10974 {

  private static final StringBuilder sb = new StringBuilder(), temp = new StringBuilder();
  private static int[] array;
  private static boolean[] visited;

  public static void main(String[] args) throws IOException {
    array = new int[nextInt()];
    for (int i = 0; i < array.length; i++) {
      array[i] = i + 1;
    }

    visited = new boolean[array.length];
    dfs(0);
    System.out.print(sb);
  }

  private static void dfs(int step) {
    if (step == array.length) {
      sb.append(temp).append("\n");
      return;
    }

    for (int i = 0; i < array.length; i++) {
      if (visited[i]) {
        continue;
      }

      visited[i] = true;
      int length = temp.length();
      temp.append(array[i]).append(" ");
      dfs(step + 1);
      temp.setLength(length);
      visited[i] = false;
    }
  }
}

/*
time complexity
O(N!)

critical point
basic dfs

reference
https://www.acmicpc.net/problem/10974
*/
