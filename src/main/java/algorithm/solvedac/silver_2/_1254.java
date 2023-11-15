package algorithm.solvedac.silver_2;

import static algorithm.forjava.chpa04.PalindromeUtils.isPalindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팰린드롬 만들기
 */
public class _1254 {

  public static void main(String[] args) throws IOException {
    String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
    int length = line.length(), answer = 0;
    for (int i = 0; i < length; i++) {
      if (isPalindrome(line.substring(i))) {
        answer = length + i;
        break;
      }
    }
    System.out.println(answer == 0 ? length * 2 - 1 : answer);
  }
}

/*
time complexity
O(N^2)

critical point
주어진 문자열 내 팰린드롬 탐색

reference
https://www.acmicpc.net/problem/1254
*/
