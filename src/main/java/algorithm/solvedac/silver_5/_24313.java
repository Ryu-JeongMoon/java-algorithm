package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextIntWithNegative;

import java.io.IOException;

/**
 * 알고리즘 수업 - 점근적 표기 1
 */
public class _24313 {

  public static void main(String[] args) throws IOException {
    int a1 = nextIntWithNegative(), a0 = nextIntWithNegative(), c = nextIntWithNegative(), n0 = nextIntWithNegative();
    if (a1 * n0 + a0 > c * n0) {
      System.out.print(0);
    } else if (a1 > c) {
      System.out.print(0);
    } else {
      System.out.print(1);
    }
  }
}

/*
time complexity
O(1)

critical point
모든 n >= n0에 대하여 f(n) <= c * g(n)이 존재하는가
=> f(n) > g(n), n의 계수는 a1 <= c 여도 n이 충분히 크지 않을 때 더 큰 경우가 존재할 수 있음
=> a1 > c, n의 계수가 더 큰 경우

reference
https://www.acmicpc.net/problem/24313
*/
