package algorithm.solvedac.bronze_1;

import static algorithm.util.SimpleIntReader.*;

import java.io.IOException;

/**
 * 약수
 */
public class _1037 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int current = nextInt();
      max = Math.max(current, max);
      min = Math.min(current, min);
    }
    System.out.println(min * max);
  }
}

/*
time complexity
O(N)

critical point
초기값 설정

reference
https://www.acmicpc.net/problem/1037
*/
