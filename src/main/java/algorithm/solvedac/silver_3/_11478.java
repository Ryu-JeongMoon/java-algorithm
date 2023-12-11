package algorithm.solvedac.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 서로 다른 부분 문자열의 개수
 */
public class _11478 {

  public static void main(String[] args) throws IOException {
    String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
    Set<String> distinctChars = new HashSet<>();
    for (int i = 0; i < line.length(); i++) {
      for (int j = i + 1; j <= line.length(); j++) {
        distinctChars.add(line.substring(i, j));
      }
    }
    System.out.println(distinctChars.size());
  }
}

/*
time complexity
O(N^2)

critical point
brute force

reference
https://www.acmicpc.net/problem/11478
*/
