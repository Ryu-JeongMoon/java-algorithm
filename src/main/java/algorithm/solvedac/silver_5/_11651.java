package algorithm.solvedac.silver_5;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import algorithm.util.FastIO;

/**
 * 좌표 정렬하기 2
 */
public class _11651 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int n = io.nextInt();
    int[][] points = new int[n][2];
    for (int i = 0; i < n; i++) {
      points[i][0] = io.nextInt();
      points[i][1] = io.nextInt();
    }
    Arrays.sort(points, Comparator.comparingInt((int[] point) -> point[1]).thenComparingInt((int[] point) -> point[0]));

    for (int[] point : points) {
      io.writeInt(point[0]);
      io.writeBuffer((byte) ' ');
      io.writelnInt(point[1]);
    }
    io.flushAndClose();
  }
}

/*
time complexity
O(NlogN)

critical point

reference
https://www.acmicpc.net/problem/11651
*/
