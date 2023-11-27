package algorithm.solvedac.silver_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 최대 곱
 */
public class _1500 {

  public static void main(String[] args) throws IOException {
    int s = nextInt(), k = nextInt(), base = s / k, remainders = s % k;
    long result = 1;
    for (int i = 0; i < k - remainders; i++) {
      result *= base;
    }
    for (int i = 0; i < remainders; i++) {
      result *= (base + 1);
    }
    System.out.println(result);
  }
}

/*
time complexity
O(n)

critical point
k개의 수가 균등하게 분포되어 있어야 최대 곱!?

reference
https://www.acmicpc.net/problem/1500
*/
