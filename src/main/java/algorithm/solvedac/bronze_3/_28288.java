package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Special Event
 */
public class _28288 {

  private static final char PRESENT = 'Y';

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] possible = new int[5];
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < line.length(); j++) {
        if (line.charAt(j) == PRESENT) {
          ++possible[j];
        }
      }
    }

    int max = 0;
    for (int p : possible) {
      max = Math.max(max, p);
    }

    List<Integer> maxValues = new ArrayList<>();
    for (int i = 0; i < possible.length; i++) {
      if (possible[i] == max) {
        maxValues.add(i + 1);
      }
    }

    String answer = maxValues.stream()
      .map(String::valueOf)
      .collect(Collectors.joining(","));

    System.out.println(answer);
  }
}

/*
time complexity
O(N)

critical point

reference
https://www.acmicpc.net/problem/28288
*/
