package algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 상수
 */
public class _2908 {

  public static void main(String[] args) throws IOException {
//    sol_1();
//    sol_2();
    sol_3();
  }

  private static void sol_1() throws IOException {
    String[] s = new String[7];
    for (int i = 0; i < s.length; i++) {
      int ch = System.in.read();
      if (ch == ' ') {
        continue;
      }
      s[6 - i] = String.valueOf((char) ch);
    }

    int firstOne = Integer.parseInt(s[4] + s[5] + s[6]);
    int secondOne = Integer.parseInt(s[0] + s[1] + s[2]);
    System.out.println(Math.max(firstOne, secondOne));
  }

  private static void sol_2() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int firstOne = Integer.parseInt(new StringBuilder(s[0]).reverse().toString());
    int secondOne = Integer.parseInt(new StringBuilder(s[1]).reverse().toString());
    System.out.println(Math.max(firstOne, secondOne));
  }

  private static void sol_3() throws IOException {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while(true) {
      int ch = System.in.read();
      if (ch == '\n') {
        i = Math.max(i, Integer.parseInt(sb.reverse().toString()));
        break;
      }

      if (ch == ' ') {
        i = Integer.parseInt(sb.reverse().toString());
        sb = new StringBuilder();
        continue;
      }
      sb.append((char) ch);
    }
    System.out.println(i);
  }
}
