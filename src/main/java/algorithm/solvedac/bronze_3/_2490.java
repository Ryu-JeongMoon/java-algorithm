package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 윷놀이
 */
public class _2490 {

  private static final String[] RESULT = { "D", "C", "B", "A", "E" };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int[] arr;
    for (int i = 0; i < 3; i++) {
      arr = new int[2];
      char[] chars = br.readLine().toCharArray();
      for (char c : chars) {
        if (c != ' ') {
          arr[c - '0']++;
        }
      }
      sb.append(RESULT[arr[1]]).append("\n");
    }
    System.out.println(sb);
  }
}

/*
time complexity
O(1)

critical point
윷 1-0개, 걸 C 1-1개, 개 1-2개, 도 A 1-3개, 모 1-4개

reference
https://www.acmicpc.net/problem/2490
 */