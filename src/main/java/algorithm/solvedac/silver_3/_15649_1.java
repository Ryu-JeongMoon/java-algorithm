package algorithm.solvedac.silver_3;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

import algorithm.util.FastIO;

/**
 * N과 M (1)
 */
public class _15649_1 {

  private static FastIO io;

  public static void main(String[] args) throws IOException {
    io = new FastIO();
    int total = io.nextInt(), target = io.nextInt();
    boolean[] visited = new boolean[total];
    Deque<Integer> numbers = new ArrayDeque<>(total);

    for (int i = 0; i < total; i++) {
      numbers.add(i + 1);
      visited[i] = true;
      visit(visited, target, numbers);
      numbers.pollLast();
      visited[i] = false;
    }
    io.flushAndClose();
  }

  private static void visit(boolean[] visited, int target, Deque<Integer> numbers) {
    for (int i = 0; i < visited.length; i++) {
      if (numbers.size() == target) {
        for (int number : numbers) {
          io.writeInt(number);
          io.writeBuffer((byte) ' ');
        }
        io.writeBuffer((byte) '\n');
        io.flushBuffer();
        return;
      }

      if (!visited[i]) {
        visited[i] = true;
        numbers.add(i + 1);
        visit(visited, target, numbers);
        numbers.pollLast();
        visited[i] = false;
      }
    }
  }
}

/*
time complexity
O(N!)

critical point
recursive backtracking

reference
https://www.acmicpc.net/problem/15649
*/
