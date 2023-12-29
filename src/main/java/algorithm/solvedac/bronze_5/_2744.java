package algorithm.solvedac.bronze_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 대소문자 바꾸기
 */
public class _2744 {

  public static void main(String[] args) throws IOException {
    String word = new BufferedReader(new InputStreamReader(System.in)).readLine();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
      char current = word.charAt(i);
      sb.append(Character.isLowerCase(current) ? Character.toUpperCase(current) : Character.toLowerCase(current));
    }
    System.out.println(sb);
  }
}

/*
time complexity
O(N)

critical point

reference
https://www.acmicpc.net/problem/2744
*/
