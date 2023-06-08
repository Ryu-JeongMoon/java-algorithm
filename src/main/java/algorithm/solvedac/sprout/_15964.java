package algorithm.solvedac.sprout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이상한 기호
 */
public class _15964 {

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    System.out.println((Long.parseLong(s[0]) + Long.parseLong(s[1])) * (Long.parseLong(s[0]) - Long.parseLong(s[1])));
  }
}

/*
time complexity
O(1)

critical point

reference
https://www.acmicpc.net/problem/15964
*/
