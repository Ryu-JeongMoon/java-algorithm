package algorithm.baekjoon.string;

import java.io.IOException;

/**
 * 다이얼
 */
public class _5622 {

  static int[] ints = { 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10 };

  public static void main(String[] args) throws IOException {
    int time = 0;
    while (true) {
      int ch = System.in.read();
      if (ch == '\n') {
        System.out.println(time);
        break;
      }
      time += ints[ch - 65];
    }
  }
}
