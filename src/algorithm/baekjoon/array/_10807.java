package algorithm.baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개수 세기
 */
public class _10807 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int[] ints = new int[201];
    for (int i = 0; i < n; i++) {
      ints[100 + Integer.parseInt(st.nextToken())]++;
    }

    st = new StringTokenizer(br.readLine());
    int v = Integer.parseInt(st.nextToken());
    System.out.println(ints[100 + v]);
  }
}
