package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.*;

import java.io.IOException;
import java.util.Arrays;

/**
 * 수리공 항승
 */
public class _1449 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), l = nextInt();
    int[] holes = new int[n];
    for (int i = 0; i < n; i++) {
      holes[i] = nextInt();
    }
    Arrays.sort(holes);

    int tapes = 0;
    float previous = Float.MIN_VALUE;
    for (int current : holes) {
      if (current > previous) {
        previous = current - 0.5f + l;
        ++tapes;
      }
    }
    System.out.println(tapes);
  }
}

/*
time complexity
O(NlogN)

critical point
정렬 후 이전 테이프 범위에 속하는지 판단

reference
https://www.acmicpc.net/problem/1449
*/
