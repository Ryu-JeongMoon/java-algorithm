package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 유진수
 */
public class _1356 {

  public static void main(String[] args) throws IOException {
    String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
    if (s.length() < 2) {
      System.out.println("NO");
      return;
    }

    for (char i = 0; i < s.length(); i++) {
      if (getInt(s.substring(0, i + 1)) == getInt(s.substring(i + 1))) {
        System.out.println("YES");
        return;
      }
    }
    System.out.println("NO");
  }

  private static int getInt(String s) {
    int result = 1;
    for (char i = 0; i < s.length(); i++) {
      result *= s.charAt(i) - '0';
    }
    return result;
  }
}

/*
time complexity
O(1)

critical point
Integer.MAX_VALUE 범위, 곱의 최댓값 9^9 -> 387,420,489
Integer 최대 범위 초과하지 않으므로 getInt()의 반환값으로 int 사용
brute-force 풀이하는데 앞/뒤 그룹의 반복은 최대 9번

reference
https://www.acmicpc.net/problem/1356
 */