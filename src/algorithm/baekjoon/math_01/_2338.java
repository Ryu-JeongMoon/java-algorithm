package algorithm.baekjoon.math_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * 긴자리 계산
 */
public class _2338 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BigDecimal a = new BigDecimal(br.readLine());
    BigDecimal b = new BigDecimal(br.readLine());

    System.out.println(a.add(b));
    System.out.println(a.subtract(b));
    System.out.println(a.multiply(b));
  }
}

/*
1
-1

0   합
2   차
-1  곱
 */
