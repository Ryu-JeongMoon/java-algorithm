package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 돌 게임 3
 */
public class _9657 {

  public static void main(String[] args) throws IOException {
    int target = nextInt();
    System.out.println(target % 7 == 0 || target % 7 == 2 ? "CY" : "SK");
  }
}

/*
time complexity
O(1)

critical point
돌을 가져올 때 1, 3, 4개 중 하나만 선택 가능
target=2인 경우, 3 or 4개를 선택할 수 없음

reference
https://www.acmicpc.net/problem/9657
*/
