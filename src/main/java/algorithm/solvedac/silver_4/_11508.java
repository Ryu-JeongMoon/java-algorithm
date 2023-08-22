package algorithm.solvedac.silver_4;

import java.io.IOException;
import java.util.Arrays;

import algorithm.util.FastIO;

/**
 * 2+1 세일
 */
public class _11508 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int n = io.nextInt(), answer = 0;
    int[] prices = new int[n];
    for (int i = 0; i < n; i++) {
      prices[i] = io.nextInt();
    }
    Arrays.sort(prices);
    for (int i = prices.length - 1, j = 1; i >= 0; i--, j++) {
      if (j % 3 != 0) {
        answer += prices[i];
      }
    }
    io.writeInt(answer);
    io.flushAndClose();
  }
}

/*
time complexity
O(NlogN)

critical point
1. 큰 수부터 제거할 수 있도록 해야 함
2. 가장 저렴한 값을 마지막에 계산할 수 있도록 해야 함
두 조건을 만족 시키기 위해 정렬 후 역순 순회

reference
https://www.acmicpc.net/problem/11508
*/
