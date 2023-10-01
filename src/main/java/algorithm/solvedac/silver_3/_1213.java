package algorithm.solvedac.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팰린드롬 만들기
 */
public class _1213 {

  public static void main(String[] args) throws IOException {
    char[] chars = new BufferedReader(new InputStreamReader(System.in))
      .readLine()
      .toCharArray();

    int[] alphabet = new int[26];
    for (char c : chars) {
      ++alphabet[c - 'A'];
    }

    int oddCount = 0;
    for (int i : alphabet) {
      if (i % 2 == 1) {
        if (++oddCount > 1 || chars.length % 2 == 0) {
          System.out.println("I'm Sorry Hansoo");
          return;
        }
      }
    }

    char oddChar = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < alphabet.length; i++) {
      if (alphabet[i] % 2 == 1) {
        oddChar = (char) (i + 'A');
      }
      for (int j = 0; j < alphabet[i] / 2; j++) {
        sb.append((char) (i + 'A'));
      }
    }

    if (oddChar != 0) {
      System.out.println(sb.toString() + oddChar + sb.reverse());
    } else {
      System.out.println(sb.toString() + sb.reverse());
    }
  }
}

/*
time complexity
O(N)

critical point
팰린드롬을 만들 수 없는 경우의 수 고려

reference
https://www.acmicpc.net/problem/1213
*/
