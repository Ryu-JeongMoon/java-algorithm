package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * 암호제작
 */
public class _1837 {

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    BigDecimal n = new BigDecimal(s[0]);
    for (int i = 2; i < Integer.parseInt(s[1]); i++) {
      BigDecimal[] bigDecimals = n.divideAndRemainder(BigDecimal.valueOf(i));
      if (bigDecimals[1].compareTo(BigDecimal.ZERO) == 0) {
        System.out.println("BAD " + i);
        return;
      }
    }
    System.out.println("GOOD");
  }
}

/*
time complexity
BigDecimal 사용으로 매우 느림, m만큼 반복 돌리므로 O(m)

critical point
4 ≤ P ≤ 10^100
2 ≤ K ≤ 10^6
n을 인수분해한 값들을 m과 비교하여 m보다 작은 (1이 아닌) 값이 있다면 가장 작은 값 출력

reference
https://www.acmicpc.net/problem/1837
 */