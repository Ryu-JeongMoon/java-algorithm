package algorithm.baekjoon.math_02;

import static algorithm.util.PrimeUtils.*;
import static algorithm.util.SimpleIntReader.*;

import java.io.IOException;

/**
 * 소수 찾기
 */
public class _1978 {

  public static void main(String[] args) throws IOException {
    int t = nextInt(), count = 0;
    for (int i = 0; i < t; i++) {
      int input = nextInt();
      if (input == 2 || (input % 2 != 0 && isPrime(input))) {
        ++count;
      }
    }
    System.out.println(count);
  }
}

/*
time complexity
O(N * sqrt(N))

critical point
2는 예외

reference
https://www.acmicpc.net/problem/1978
*/
