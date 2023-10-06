package algorithm.solvedac.silver_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * 놀라운 문자열
 */
public class _1972 {

  private static final String SURPRISING = "%s is surprising.";
  private static final String NOT_SURPRISING = "%s is NOT surprising.";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Set<String> pairs = new HashSet<>();
    String line;
    outer:
    while (!(line = br.readLine()).equals("*")) {
      for (int i = 1; i < line.length(); i++) {
        pairs.clear();
        for (int j = 0; j + i < line.length(); j++) {
          String pair = line.charAt(j) + "" + line.charAt(j + i);
          if (pairs.contains(pair)) {
            bw.write(String.format(NOT_SURPRISING, line));
            bw.newLine();
            continue outer;
          } else {
            pairs.add(pair);
          }
        }
      }
      bw.write(String.format(SURPRISING, line));
      bw.newLine();
    }
    bw.flush();
    bw.close();
  }
}

/*
time complexity
O(N^2)

critical point
거리 별 중복 체크

reference
https://www.acmicpc.net/problem/1972
*/
