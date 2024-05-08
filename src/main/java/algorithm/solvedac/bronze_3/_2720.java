package algorithm.solvedac.bronze_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 세탁소 사장 동혁
 */
public class _2720 {

  public static void main(String[] args) throws IOException {
    int[] coins = { 25, 10, 5, 1 };
    StringBuilder sb = new StringBuilder();
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      int amount = nextInt();
      for (int coin : coins) {
        sb.append(amount / coin).append(" ");
        amount %= coin;
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(N)

critical point

reference
https://www.acmicpc.net/problem/2720
*/
