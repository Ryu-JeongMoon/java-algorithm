package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 악수
 */
public class _8394 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), pprev = 1, prev = 1, current = 1;
    for (int i = 2; i <= n; i++) {
      current = (pprev + prev) % 10;
      pprev = prev % 10;
      prev = current % 10;
    }
    System.out.println(current);
  }
}

/*
time complexity
O(N)

critical point
점화식 찾기

reference
https://www.acmicpc.net/problem/8394
*/
