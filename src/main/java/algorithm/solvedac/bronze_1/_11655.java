package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * ROT13
 */
public class _11655 {

  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    char[] chars = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
    for (char current : chars) {
      if (Character.isAlphabetic(current)) {
        char offset = Character.isUpperCase(current) ? 'A' : 'a';
        bw.write((char) (offset + ((current - offset + 13) % 26)));
      } else {
        bw.write(current);
      }
    }
    bw.flush();
    bw.close();
  }
}

/*
time complexity
O(n)

critical point
char casting

reference
https://www.acmicpc.net/problem/11655
*/
