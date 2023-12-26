package algorithm.solvedac.silver_3;

import java.io.IOException;
import java.util.Arrays;

import algorithm.util.FastIO;

/**
 * N과 M (5)
 */
public class _15654 {

  private static final StringBuilder sb = new StringBuilder();
  private static final FastIO io = new FastIO();
  private static int n, m;
  private static int[] array;
  private static int visitedMask = 0;

  public static void main(String[] args) throws IOException {
    n = io.nextInt();
    m = io.nextInt();
    array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = io.nextInt();
    }
    Arrays.sort(array);

    dfs(0);
    io.flushAndClose();
  }

  private static void dfs(int step) {
    if (step == m) {
      io.writeln(sb.toString());
      return;
    }

    for (int i = 0; i < n; i++) {
      if ((visitedMask & (1 << i)) != 0) {
        continue;
      }

      visitedMask |= (1 << i);
      int length = sb.length();
      sb.append(array[i]).append(" ");
      dfs(step + 1);
      sb.delete(length, sb.length());
      visitedMask &= ~(1 << i);
    }
  }
}

/*
time complexity
O(NlogN + N * M)

critical point
정렬 순서 주의
visited array 대신 bitmask 사용 -> VisitUtils

reference
https://www.acmicpc.net/problem/15654
*/
