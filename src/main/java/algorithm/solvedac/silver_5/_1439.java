package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 뒤집기
 */
public class _1439 {

  public static void main(String[] args) throws IOException {
    String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
    char current = s.charAt(0);
    int flipCount = 0;
    for (int i = 1; i < s.length(); i++) {
      if (current != s.charAt(i)) {
        current = s.charAt(i);
        ++flipCount;
      }
    }
    System.out.println(flipCount % 2 == 0 ? flipCount / 2 : (flipCount + 1) / 2);
  }
}

/*
time complexity
O(N)

critical point
flipCount 짝수인 경우 1번 뒤집으면 됨, O X O
flipCount 홀수인 경우 2번 뒤집어야 함, O X O X
flipCount는 3이지만 뒤집이어야 하는 횟수는 2번이므로
flipCount = (flipCount + 1) / 2

reference
https://www.acmicpc.net/problem/1439
 */