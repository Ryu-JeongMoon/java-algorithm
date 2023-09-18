package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.*;

import java.io.IOException;
import java.math.BigInteger;

/**
 * 조합
 */
public class _2407 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), m = nextInt(), bigger = Math.max(n - m, m);
    BigInteger denominator = BigInteger.ONE, numerator = BigInteger.ONE;
    for (int i = bigger + 1; i <= n; i++) {
      denominator = denominator.multiply(BigInteger.valueOf(i));
      numerator = numerator.multiply(BigInteger.valueOf(i - bigger));
    }
    System.out.println(denominator.divide(numerator));
  }
}

/*
time complexity
O(N)

critical point
n-m, n 중 큰 수 기준 계산
n 100, m 6 일 때, 100! / ((100-6)! * 6!) 이므로
분모는 100 ~ 95, 분자는 6 ~ 1 의 곱

reference
https://www.acmicpc.net/problem/2407
*/
