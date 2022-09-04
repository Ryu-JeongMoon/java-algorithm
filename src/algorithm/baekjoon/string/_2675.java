package algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 문자열 반복
 */
public class _2675 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      String[] input = br.readLine().split(" ");
      int r = Integer.parseInt(input[0]);
      String s = input[1];
      for (int i = 0; i < s.length(); i++) {
        for (int j = 0; j < r; j++) {
          bw.write(s.charAt(i));
        }
      }
      bw.newLine();
    }
    bw.flush();
  }
}
