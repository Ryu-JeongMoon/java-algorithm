package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * 비밀편지
 */
public class _2596 {

  private static final Map<String, String> CHARACTERS = Map.of(
    "000000", "A", "001111", "B", "010011", "C", "011100", "D",
    "100110", "E", "101001", "F", "110101", "G", "111010", "H");

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] ciphers = new String[Integer.parseInt(br.readLine())];
    String line = br.readLine();
    for (int i = 0; i < ciphers.length; i++) {
      ciphers[i] = line.substring(i * 6, i * 6 + 6);
    }
    StringBuilder sb = new StringBuilder();
    outer:
    for (int i = 0; i < ciphers.length; i++) {
      for (Map.Entry<String, String> entry : CHARACTERS.entrySet()) {
        if (getDifference(ciphers[i], entry.getKey()) < 2) {
          sb.append(entry.getValue());
          continue outer;
        }
      }
      sb.setLength(0);
      sb.append(i + 1);
      break;
    }
    System.out.println(sb);
  }

  private static int getDifference(String input, String target) {
    int count = 0;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) != target.charAt(i)) {
        ++count;
      }
    }
    return count;
  }
}

/*
time complexity
O(N)

critical point

reference
https://www.acmicpc.net/problem/2596
*/
