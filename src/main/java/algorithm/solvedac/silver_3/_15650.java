package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * N과 M (2)
 */
public class _15650 {

  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static int n, m;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    n = nextInt();
    m = nextInt();
    arr = new int[m];
    dfs(0);
    bw.flush();
    bw.close();
  }

  private static void dfs(int step) throws IOException {
    if (step == m) {
      for (int j : arr) {
        bw.write(j + " ");
      }
      bw.newLine();
      return;
    }

    for (int i = step; i < n; i++) {
      arr[step] = i + 1;
      if (step > 0 && arr[step] <= arr[step - 1]) {
        continue;
      }
      dfs(step + 1);
    }
  }
}

/*
time complexity
O(n^m)

critical point
중복 불가, 오름차순 정렬
앞수와 같은 수를 고른 경우 생략

reference
https://www.acmicpc.net/problem/15650
*/
