package algorithm.baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 알파벳 개수
 */
public class _10808 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String word = st.nextToken();
    char[] chars = word.toCharArray();

    int[] alphabets = new int[26];
    for (char c : chars) {
      int index = c - 97;
      alphabets[index]++;
    }

    StringBuilder sb = new StringBuilder();
    for (int alphabet : alphabets) {
      sb.append(alphabet).append(" ");
    }

    System.out.println(sb);
  }
}
