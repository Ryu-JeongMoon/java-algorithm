package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 부분 문자열
 */
public class _6550 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String line;
    while ((line = br.readLine()) != null) {
      String[] words = line.split(" ");
      String s = words[0], t = words[1];
      int index = 0;
      for (int i = 0; i < t.length() && index < s.length(); i++) {
        if (t.charAt(i) == s.charAt(index)) {
          ++index;
        }
      }
      bw.write(index == s.length() ? "Yes\n" : "No\n");
    }
    bw.flush();
    bw.close();
  }
}

/*
time complexity
O(N)

critical point
대소문자 구분

reference
https://www.acmicpc.net/problem/6550
*/
