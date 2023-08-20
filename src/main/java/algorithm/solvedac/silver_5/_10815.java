package algorithm.solvedac.silver_5;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import algorithm.util.FastIO;

/**
 * 숫자 카드
 */
public class _10815 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int n = io.nextInt();
    Set<Integer> cards = new HashSet<>(n);
    for (int i = 0; i < n; i++) {
      cards.add(io.nextInt());
    }

    int m = io.nextInt();
    for (int i = 0; i < m; i++) {
      io.writeInt(cards.contains(io.nextInt()) ? 1 : 0);
      io.writeBuffer((byte) ' ');
    }
    io.flushAndClose();
  }
}

/*
time complexity
O(NlogN)

critical point

reference
https://www.acmicpc.net/problem/10815
*/
