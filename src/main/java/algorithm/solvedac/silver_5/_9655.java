package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 돌 게임
 */
public class _9655 {

  public static void main(String[] args) throws IOException {
    System.out.println(nextInt() % 2 == 1 ? "SK" : "CY");
  }
}

/*
time complexity
O(1)

critical point

reference
https://www.acmicpc.net/problem/9655
*/
