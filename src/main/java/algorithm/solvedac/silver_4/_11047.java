package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 동전 0
 */
public class _11047 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), k = nextInt(), count = 0;
    int[] coins = new int[n];
    for (int i = 0; i < n; i++) {
      coins[i] = nextInt();
    }
    for (int i = 0; i < n && k != 0; i++) {
      int current = coins[n - 1 - i];
      if (k >= current) {
        int share = k / current;
        count += share;
        k -= current * share;
      }
    }
    System.out.println(count);
  }
}

/*
time complexity
O(N)

critical point
동전 배수 관계

reference
https://www.acmicpc.net/problem/11047
*/
