package algorithm.solvedac.silver_4;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

import algorithm.util.FastIO;

/**
 * 카드
 */
public class _1835 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int n = io.nextInt();
    if (n == 1) {
      io.writeInt(n);
      io.flushAndClose();
      return;
    }

    Queue<Integer> indices = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      indices.add(i);
    }

    int[] cards = new int[n];
    int value = 1;
    while (!indices.isEmpty()) {
      for (int i = 0; i < value % indices.size(); i++) {
        indices.add(indices.poll());
      }
      cards[indices.poll()] = value++;
    }

    for (int card : cards) {
      io.writeInt(card);
      io.writeBuffer((byte) ' ');
    }
    io.flushAndClose();
  }
}

/*
time complexity
O(N^2)

critical point
while 문 내부, value % indices.size() 로 범위 제한
3개의 수가 남은 경우, 4번 섞는 것은 1번 섞는 것과 같은 결과를 가짐
1 2 3
1. 2 3 1
2. 3 1 2
3. 1 2 3
4. 2 3 1

reference
https://www.acmicpc.net/problem/1835
*/
