package algorithm.baekjoon.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Strfry
 */
public class _11328 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());

    String[] words = new String[2];
    for (int i = 0; i < n; i++) {
      words = br.readLine().split(" ");
      bw.write(strfry(words[0], words[1]) + "\n");
    }
    bw.flush();
    bw.close();
  }

  private static String strfry(String s1, String s2) {
    if (s1.equals(s2)) {
      return "Possible";
    } else if (s1.length() != s2.length()) {
      return "Impossible";
    }

    int[] alphabets1 = new int[26];
    int[] alphabets2 = new int[26];

    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();

    for (int i = 0; i < c1.length; i++) {
      alphabets1[c1[i] - 'a'] += 1;
      alphabets2[c2[i] - 'a'] += 1;
    }

    for (int i = 0; i < alphabets1.length; i++) {
      if (alphabets1[i] != alphabets2[i]) {
        return "Impossible";
      }
    }
    return "Possible";
  }
}