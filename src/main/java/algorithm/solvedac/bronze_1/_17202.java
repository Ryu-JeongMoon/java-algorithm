package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 핸드폰 번호 궁합
 */
public class _17202 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String first = br.readLine(), second = br.readLine();
    StringBuilder answer = new StringBuilder();
    for (int i = 0; i < first.length(); i++) {
      answer.append(first.charAt(i)).append(second.charAt(i));
    }

    StringBuilder temp = new StringBuilder();
    while (answer.length() != 2) {
      temp.setLength(0);
      for (int i = 0; i < answer.length() - 1; i++) {
        temp.append((answer.charAt(i) - '0' + answer.charAt(i + 1) - '0') % 10);
      }
      answer.setLength(0);
      answer.append(temp);
    }
    System.out.println(answer);
  }
}

/*
time complexity
O(N)

critical point

reference
https://www.acmicpc.net/problem/17202
*/
