package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 미터계
 */
public class _1862 {

  public static void main(String[] args) throws IOException {
    String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
    long sum = 0;
    for (int i = 0; i < input.length(); i++) {
      char current = input.charAt(i);
      int currentValue = current > '3' ? current - '1' : current - '0';
      sum += (long) (currentValue * Math.pow(9, input.length() - i - 1));
    }
    System.out.println(sum);
  }
}

/*
time complexity
O(N)

critical point
자리수 별 9진수 to 10진수 변환
자리수가 4 이상인 경우 4를 포함하면 안 되므로 -1

reference
https://www.acmicpc.net/problem/1862
*/
