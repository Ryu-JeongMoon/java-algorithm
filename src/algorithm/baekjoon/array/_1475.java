package algorithm.baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 방 번호
 */
public class _1475 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] ints = new int[10];
    char[] chars = st.nextToken().toCharArray();

    for (char c : chars) {
      if (c == '9') {
        ints[c - '3']++;
      } else {
        ints[c - '0']++;
      }
    }

    if (ints[6] % 2 == 0) {
      ints[6] /= 2;
    } else {
      ints[6] = ints[6] / 2 + 1;
    }

    int max = 0;
    for (int i : ints) {
      if (i > max) {
        max = i;
      }
    }
    System.out.println(max);
  }
}
