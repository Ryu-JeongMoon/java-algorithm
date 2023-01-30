package algorithm.baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 세수정렬
 */
public class _2752 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int max = 0, medium = 0, min = 0;

    if (a > b) {
      max = Math.max(a, c);
      medium = Math.max(b, Math.min(a, c));
      min = Math.min(b, Math.min(a, c));
    } else {
      max = Math.max(b, c);
      medium = Math.max(a, Math.min(b, c));
      min = Math.min(a, Math.min(b, c));
    }

    System.out.printf("%d %d %d", min, medium, max);
  }
}
