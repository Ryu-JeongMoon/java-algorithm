package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 전자레인지
 */
public class _10162 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    if (t % 10 != 0) {
      System.out.println(-1);
      return;
    }

    int[][] buttonAndCounts = { { 300, 0 }, { 60, 0 }, { 10, 0 } };
    for (int i = 0; i < buttonAndCounts.length; i++) {
      while (t >= buttonAndCounts[i][0]) {
        t -= buttonAndCounts[i][0];
        ++buttonAndCounts[i][1];
      }
    }

    for (int[] buttonAndCount : buttonAndCounts) {
      System.out.print(buttonAndCount[1] + " ");
    }
    br.close();
  }
}

/*
time complexity
O(1)

critical point

reference
https://www.acmicpc.net/problem/10162
*/
