package algorithm.baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 두 수의 합
 */
public class _3273 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());

    int[] ints = new int[2000000];
    for (int i = 0; i < n; i++) {
      ints[Integer.parseInt(st.nextToken())] = 1;
    }

    st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());

    int count = 0;
    for (int i = 1; i < (x + 1) / 2; i++) {
      if (ints[i] == 1 && ints[x - i] == 1) {
        count++;
      }
    }

    System.out.println(count);
  }
}
