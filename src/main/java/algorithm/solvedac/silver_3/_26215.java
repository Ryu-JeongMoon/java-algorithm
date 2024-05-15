package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 눈 치우기
 */
public class _26215 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), count = 0;
    Queue<Integer> queue = new PriorityQueue<>(n, Comparator.reverseOrder());
    for (int i = 0; i < n; i++) {
      queue.add(nextInt());
    }

    while (!queue.isEmpty()) {
      int first = queue.poll();
      if (queue.isEmpty()) {
        count += first;
        break;
      }

      ++count;

      int second = queue.poll();
      if (first != 1) {
        queue.add(first - 1);
      }
      if (second != 1) {
        queue.add(second - 1);
      }
    }
    System.out.println(count > 1440 ? -1 : count);
  }
}

/*
time complexity
O(N * log(N))

critical point
집 위치와 관계 없이 두 집까지 선택 가능

reference
https://www.acmicpc.net/problem/26215
*/
