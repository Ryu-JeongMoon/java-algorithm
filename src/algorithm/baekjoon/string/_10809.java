package algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 알파벳 찾기
 */
public class _10809 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] alphabets = new int[26];
    Arrays.fill(alphabets, -1);

    char[] chars = br.readLine().toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (alphabets[chars[i] - 'a'] == -1)
        alphabets[chars[i] - 'a'] = i;
    }

    StringBuilder sb = new StringBuilder();
    for (int a : alphabets)
      sb.append(a).append(" ");

    System.out.println(sb);
  }
}