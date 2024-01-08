package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 돌 게임 2
 */
public class _9656 {

  public static void main(String[] args) throws IOException {
    System.out.println(nextInt() % 2 == 0 ? "SK" : "CY");
  }
}

/*
time complexity
O(1)

critical point
규칙 찾기

reference
https://www.acmicpc.net/problem/9656
*/
