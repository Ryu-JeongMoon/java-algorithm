package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팰린드롬인지 확인하기
 */
public class _10988 {

  public static void main(String[] args) throws IOException {
    String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
    int length = input.length();
    for (int i = 0; i < length / 2; i++) {
      if (input.charAt(i) != input.charAt(length - 1 - i)) {
        System.out.println(0);
        return;
      }
    }
    System.out.println(1);
  }
}

/*
time complexity
O(n)

critical point
인덱스 계산 조심

reference
https://www.acmicpc.net/problem/10988
*/
