package algorithm.solvedac.silver_4;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * 주유소
 */
public class _13305 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int n = io.nextInt();
    int[] distance = new int[n - 1], prices = new int[n];
    for (int i = 0; i < n - 1; i++) {
      distance[i] = io.nextInt();
    }
    for (int i = 0; i < n; i++) {
      prices[i] = io.nextInt();
    }
    long sum = 0, price = Integer.MAX_VALUE;
    for (int i = 0; i < n - 1; i++) {
      price = Math.min(price, prices[i]);
      sum += price * distance[i];
    }
    io.writeLong(sum);
    io.flushAndClose();
  }
}

/*
time complexity
O(N)

critical point
마지막 마을의 주유 가격은 고려할 필요 없음
주유 가격이 낮아질 때만 가격 변경

reference
https://www.acmicpc.net/problem/13305
*/
