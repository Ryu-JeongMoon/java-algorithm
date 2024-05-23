package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 문자열 집합
 */
public class _14425 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] counts = br.readLine().split(" ");

    Set<String> set = new HashSet<>();
    int n = Integer.parseInt(counts[0]);
    for (int i = 0; i < n; i++) {
      set.add(br.readLine());
    }

    int m = Integer.parseInt(counts[1]), count = 0;
    for (int i = 0; i < m; i++) {
      if (set.contains(br.readLine())) {
        ++count;
      }
    }
    System.out.println(count);
  }
}

/*
time complexity
O(n)

critical point

reference
https://www.acmicpc.net/problem/14425
*/
