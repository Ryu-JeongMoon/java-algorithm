package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 뒤집힌 덧셈
 */
public class _1357 {

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    System.out.println(revert(Integer.parseInt(revert(s[0])) + Integer.parseInt(revert(s[1])) + ""));
  }

  private static String revert(String value) {
    StringBuilder sb = new StringBuilder();
    for (int i = value.length() - 1; i >= 0; i--) {
      if (sb.length() != 0 || value.charAt(i) != '0') {
        sb.append(value.charAt(i));
      }
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }
}

/*
time complexity
O(N)

critical point
sb.length() != 0 || value.charAt(i) != '0'
sb.length() 0이 아닌 경우, sb.append()로 추가
sb.length() 0인 경우, '0'이 온다면 앞자리 0을 무시해야하므로 추가하지 않음

!(sb.length() == 0 && value.charAt(i) == '0')
위의 경우를 드모르간의 법칙으로 표현

reference
https://www.acmicpc.net/problem/1357
 */