package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 평점 변환
 */
public class _31799 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder(Integer.parseInt(br.readLine()));
    String[] words = br.readLine().split("(?=[A-Z](?:[-+0]|))");
    String prev = "";
    for (String word : words) {
      sb.append(transform(prev, word));
      prev = word;
    }
    br.close();
    System.out.println(sb);
  }

  private static String transform(String prev, String current) {
    return switch (current) {
      case "A+" -> "E";
      case "A", "A0" -> !prev.equals("A-") && prev.contains("A") ? "P" : "E";
      case "A-", "B+" -> prev.contains("A") || prev.equals("B+") ? "D" : "P";
      case "B", "B0", "B-" -> prev.contains("C") || prev.isEmpty() ? "D" : "B";
      default -> "B";
    };
  }
}

/*
time complexity
O(N)

critical point
(?=[a-zA-Z](?:[-+0]|))

?=         : positive lookahead
?!         : negative lookahead
(?:[-+0]|) : a non-capturing group that matches a single character of '-' or '+' or '0' or '' (empty string)

reference
https://www.acmicpc.net/problem/31799
*/
