package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 숫자 놀이
 */
public class _2145 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String line;
    while (!(line = br.readLine()).equals("0")) {
      int sum = 0;
      for (int i = 0; i < line.length(); i++) {
        sum += (line.charAt(i) - '0');
      }

      while (sum >= 10) {
        sum = sum / 10 + sum % 10;
      }
      sb.append(sum).append("\n");
    }
    System.out.print(sb);
  }
}

/*
time complexity
n을 라인 수, m을 한 라인의 길이라 할 때
O(nm)

critical point

reference
https://www.acmicpc.net/problem/2145
 */
