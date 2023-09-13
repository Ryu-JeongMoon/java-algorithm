package algorithm.solvedac.silver_3;

import java.io.IOException;
import java.util.LinkedList;
import java.util.TreeSet;

import algorithm.util.FastIO;

/**
 * 프린터 큐
 */
public class _1966 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();

    LinkedList<Pair> queue = new LinkedList<>();
    TreeSet<Integer> priorities = new TreeSet<>();

    int total = io.nextInt();
    while (--total >= 0) {
      int n = io.nextInt(), index = io.nextInt(), count = 0;
      int[] frequencies = new int[9];
      for (int i = 0; i < n; i++) {
        int priority = io.nextInt();
        queue.offer(new Pair(i, priority));
        priorities.add(priority);
        frequencies[priority - 1] += 1;
      }

      while (!queue.isEmpty()) {
        Pair current;
        while ((current = queue.poll()).priority != priorities.last()) {
          queue.offer(current);
        }

        if (current.index == index) {
          io.writelnInt(++count);
          priorities.clear();
          queue.clear();
          break;
        } else {
          frequencies[current.priority - 1] -= 1;
          if (frequencies[current.priority - 1] == 0) {
            priorities.pollLast();
          }
          count++;
        }
      }
    }
    io.flushAndClose();
  }

  private static class Pair {

    int index, priority;

    private Pair(int index, int priority) {
      this.index = index;
      this.priority = priority;
    }
  }
}

/*
time complexity
O(N^2)

critical point
우선 순위에 따라 제거 필요, 요소 별 우선 순위는 중복될 수 있음

reference
https://www.acmicpc.net/problem/1966
*/
