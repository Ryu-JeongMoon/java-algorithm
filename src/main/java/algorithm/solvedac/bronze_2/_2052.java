package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * 지수연산
 */
public class _2052 {

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
    solution1(n);
    solution2(n);
  }

  private static void solution1(int n) {
    if (n < 10) {
      System.out.println(Math.pow(0.5, n));
    } else {
      System.out.println(new BigDecimal(Math.pow(2, -n)).toPlainString());
    }
  }

  private static void solution2(int n) {
    if (n < 10) {
      System.out.println(Math.pow(0.5, n));
    } else {
      String value = String.format("%.250f", BigDecimal.valueOf(0.5).pow(n));
      int length = value.length();
      while (value.charAt(--length) == '0') {
      }
      System.out.println(value.substring(0, length + 1));
    }
  }
}

/*
time complexity
O(1)

BigDecimal 내부에서 Normalize 과정에 항상 50번 반복
// Normalize
while ((significand & 1) == 0) { // i.e., significand is even
    significand >>= 1;
    exponent++;
}

critical point
1. double로 Math.pow() 계산하면 25 제곱 이후로 뒷자리 짤리기 시작
2. BigDecimal.valueOf(0.5).pow(250)의 소수점 이하 길이 -> 250자리라서 포맷팅에 .250f 사용
3. BigDecimal API 사용하면 간단..

solution1 80ms
solution2 88ms

reference
https://www.acmicpc.net/problem/2052
 */