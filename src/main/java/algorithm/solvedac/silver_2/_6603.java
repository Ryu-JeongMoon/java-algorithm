package algorithm.solvedac.silver_2;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * 로또
 */
public class _6603 {

  private static final FastIO IO = new FastIO();
  private static final int[] RESULT = new int[6];
  private static int[] numbers;

  public static void main(String[] args) throws IOException {
    int k;
    while ((k = IO.nextInt()) != 0) {
      numbers = new int[k];
      for (int i = 0; i < k; i++) {
        numbers[i] = IO.nextInt();
      }
      visit(0, 0);
      IO.writeBuffer((byte) '\n');
    }
    IO.flushAndClose();
  }

  private static void visit(int step, int index) {
    if (step == RESULT.length) {
      for (int i : RESULT) {
        IO.writeInt(i);
        IO.writeBuffer((byte) ' ');
      }
      IO.writeBuffer((byte) '\n');
      return;
    }

    for (int i = index; i < numbers.length; i++) {
      RESULT[step] = numbers[i];
      visit(step + 1, i + 1);
    }
  }
}

/*
time complexity
O(2^N)

critical point

reference
https://www.acmicpc.net/problem/6603
*/
