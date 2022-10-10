package algorithm.baekjoon.math_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 소수 찾기
 */
public class _1978 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();

    int countOfPrimes = 0;
    String[] numbers = br.readLine().split(" ");
    for (String number : numbers) {
      if (isPrime(number)) {
        countOfPrimes++;
      }
    }
    System.out.println(countOfPrimes);
  }

  /* number 까지 루프 돌릴 필요 없다 */
  private static boolean isPrime(String str) {
    int number = Integer.parseInt(str);
    if (number <= 1)
      return false;

    int i = 1;
    while (i++ < (int) Math.sqrt(number)) {
      if (number % i == 0) {
        return false;
      }
    }

    return true;
  }
}

/*
4
1 3 5 7
 */