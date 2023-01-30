package algorithm.baekjoon.function;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 셀프 넘버
 */
public class _4673 {

  private static final boolean[] checked = new boolean[10001];

  public static void main(String[] args) throws IOException {
    for (int i = 1; i < 10001; i++) {
      int n = check(i);
      if (n < 10001)
        checked[n] = true;
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 1; i < 10001; i++) {
      boolean isChecked = checked[i];
      if (!isChecked) {
        bw.write(i + "\n");
      }
    }

    bw.flush();
  }

  private static int check(int i) {
    int next = i;
    while (i != 0) {
      next += i % 10;
      i /= 10;
    }
    return next;
  }
}