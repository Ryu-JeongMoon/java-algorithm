package algorithm.baekjoon.math_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * 큰 수 A+B
 */
public class _10757 {

  public static void main(String[] args) throws IOException {
    String[] numbers = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    System.out.println(new BigDecimal(numbers[0]).add(new BigDecimal(numbers[1])));
  }
}

/*
BigDecimal 직접 받지 말고 구현해보기
 */