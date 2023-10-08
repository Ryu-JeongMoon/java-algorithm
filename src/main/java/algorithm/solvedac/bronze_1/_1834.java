package algorithm.solvedac.bronze_1;

import static algorithm.util.SimpleIntReader.*;

import java.io.IOException;

/**
 * 나머지와 몫이 같은 수
 */
public class _1834 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    System.out.println((long) n * (n - 1) * (n + 1) / 2);
  }
}

/*
time complexity
O(1)

critical point
3 * 1 + 1
3 * 2 + 2
일반화 하면 N (N * (N-1) / 2) + N * (N-1) / 2 = (N+1) * (N-1) * N / 2

reference
https://www.acmicpc.net/problem/1834
*/
