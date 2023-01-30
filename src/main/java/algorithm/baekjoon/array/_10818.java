package algorithm.baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최소, 최대
 */
public class _10818 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      String nextToken = st.nextToken();
      min = Math.min(min, Integer.parseInt(nextToken));
      max = Math.max(max, Integer.parseInt(nextToken));
    }

    System.out.printf("%d %d", min, max);
  }
}
