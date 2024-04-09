package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * N과 M (3)
 */
public class _15651 {

  private static final StringBuilder SB = new StringBuilder(), RESULT = new StringBuilder();
  private static int n, m;

  public static void main(String[] args) throws IOException {
    n = nextInt();
    m = nextInt();
    int counter = 0;
    for (int i = 1; i < n + 1; i++) {
      SB.setLength(0);
      SB.append(i).append(" ");
      write(counter + 1);
    }
    System.out.print(RESULT);
  }

  private static void write(int counter) {
    if (counter == m) {
      RESULT.append(SB).append("\n");
      return;
    }

    for (int i = 1; i < n + 1; i++) {
      SB.append(i).append(" ");
      write(counter + 1);
      SB.delete(SB.length() - 2, SB.length());
    }
  }
}

/*
time complexity
O(N^M)

critical point
재귀의 이해

reference
https://www.acmicpc.net/problem/15651
*/
