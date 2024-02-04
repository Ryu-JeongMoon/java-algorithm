package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 접미사 배열
 */
public class _11656 {

  public static void main(String[] args) throws IOException {
    String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
    String[] suffixes = new String[line.length()];
    for (int i = 0; i < suffixes.length; i++) {
      suffixes[i] = line.substring(i);
    }
    Arrays.sort(suffixes);
    StringBuilder sb = new StringBuilder();
    for (String suffix : suffixes) {
      sb.append(suffix).append('\n');
    }
    System.out.println(sb);
  }
}

/*
time complexity
O(NlogN)

critical point
입력값 길이 주의

reference
https://www.acmicpc.net/problem/11656
*/
