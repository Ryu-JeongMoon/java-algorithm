package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 퇴사
 */
public class _14501 {

  private static int[][] consults;
  private static boolean[] visited;
  private static int max = 0;

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    consults = new int[n][2];
    for (int i = 0; i < n; i++) {
      consults[i][0] = nextInt();
      consults[i][1] = nextInt();
    }

    visited = new boolean[n];
    visit(0, 0);
    System.out.println(max);
  }

  private static void visit(int index, int profit) {
    for (int i = index; i < visited.length; i++) {
      if (i + consults[i][0] <= visited.length && !visited[i]) {
        visited[i] = true;
        visit(i + consults[i][0], profit + consults[i][1]);
        visited[i] = false;
      }
    }
    max = Math.max(max, profit);
  }
}

/*
time complexity
O(N^2)

critical point
마지막날 상담 소요 시간이 1일 경우 포함

reference
https://www.acmicpc.net/problem/14501
*/
