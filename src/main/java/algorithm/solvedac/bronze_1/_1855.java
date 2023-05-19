package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 암호
 */
public class _1855 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(br.readLine());
    String s = br.readLine();
    String[] strings = new String[k];
    Arrays.fill(strings, "");

    for (int i = 0; i < s.length(); i++) {
      if ((i / k) % 2 == 1) {
        strings[k - 1 - (i % k)] += s.charAt(i);
      } else {
        strings[i % k] += s.charAt(i);
      }
    }

    StringBuilder result = new StringBuilder();
    for (String stringBuilder : strings) {
      result.append(stringBuilder);
    }
    System.out.println(result);
  }
}

/*
time complexity
O(n)

critical point
(i / k) % 2 == 1인 경우 역순으로 삽입해주어야 함
0 -> 1 -> 2
5 -> 4 -> 3 ...

reference
https://www.acmicpc.net/problem/1855
 */