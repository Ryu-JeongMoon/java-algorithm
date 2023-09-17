package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.*;

import java.io.IOException;

/**
 * 2 타워
 */
public class _10407 {

  public static void main(String[] args) throws IOException {
    System.out.println(nextInt() == 1 ? 2 : 1);
  }
}

/*
time complexity
O(1)

critical point
2의 거듭 제곱이 홀수 / 짝수인 경우 나눠서 고려
2^1, 2^3, 2^5 ... % 3 == 2
2^2, 2^4, 2^6 ... % 3 == 1

높이 H는 2^2^2^2 .. 2의 거듭 제곱 연속 표현
높이가 1인 경우를 제외 하면 거듭 제곱은 항상 짝수로 표현됨

1인 경우
2 % 3 == 2

그 외의 경우
2^2 % 3 == 1, 2^2^2 % 3 == 1

reference
https://www.acmicpc.net/problem/10407
*/
