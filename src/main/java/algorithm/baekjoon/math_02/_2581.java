package algorithm.baekjoon.math_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 소수
 */
public class _2581 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int start = Integer.parseInt(br.readLine());
    int end = Integer.parseInt(br.readLine());

    int[] result = findPrimeNumbers(start, end);
    if (result[0] == 0) {
      System.out.println(-1);
    } else {
      int sum = 0;
      for (int i : result) {
        if (i == 0) {
          break;
        }

        sum += i;
      }
      System.out.println(sum);
      System.out.println(result[0]);
    }
  }

  private static int[] findPrimeNumbers(int start, int end) {
    int[] result = new int[end - start + 1];
    int count = 0;
    for (int i = start; i < end + 1; i++) {
      if (isPrime(i)) {
        result[count++] = i;
      }
    }
    return result;
  }

  private static boolean isPrime(int number) {
    if (number <= 1) {
      return false;
    }

    for (int i = 2; i < (int) (Math.sqrt(number) + 1); i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}

/*
시작 - 60
끝 - 100

소수의 합 - 620
소수 중 최솟값 - 61

64
65
없으면 -1

엣지 케이스 실패..!
if (number <= 1) {
  return false;
}
 */
