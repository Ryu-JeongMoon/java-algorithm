package algorithm.solvedac.silver_2;

import static algorithm.util.SimpleIntReader.nextIntWithNegative;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * N번째 큰 수
 */
public class _2075 {

  public static void main(String[] args) throws IOException {
    int n = nextIntWithNegative();
    Queue<Integer> queue = new PriorityQueue<>(n);
    for (int i = 0; i < n * n; i++) {
      int current = nextIntWithNegative();
      if (queue.size() != n) {
        queue.add(current);
      } else if (queue.peek() < current) {
        queue.poll();
        queue.add(current);
      }
    }
    System.out.println(queue.poll());
  }
}

/*
time complexity
O(NlogN)

critical point
입력값 범위 주의

reference
https://www.acmicpc.net/problem/2075
*/
