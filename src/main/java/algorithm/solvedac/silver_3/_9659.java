package algorithm.solvedac.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 돌 게임 5
 */
public class _9659 {

  public static void main(String[] args) throws IOException {
    String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
    System.out.println((line.charAt(line.length() - 1) - '0') % 2 == 1 ? "SK" : "CY");
  }
}

/*
time complexity
O(1)

critical point
선택지는 1 or 3
둘의 합은 짝수 (2, 4, 6 중 하나)
짝수인 상태에서 선택하는 경우 무조건 패배
ex) 5
5 -> 2 (SK 3 선택) -> 1 (CY 1 선택) -> 0 (SK 1 선택)
5 -> 4 (SK 1 선택) -> 1 (CY 3 선택) -> 0 (SK 1 선택)
5 -> 4 (SK 1 선택) -> 3 (CY 1 선택) -> 0 (SK 3 선택)

reference
https://www.acmicpc.net/problem/9659
*/
