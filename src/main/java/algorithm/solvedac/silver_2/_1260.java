package algorithm.solvedac.silver_2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import algorithm.util.FastIO;

/**
 * DFS와 BFS
 */
public class _1260 {

  private static final FastIO io = new FastIO();
  private static int[][] graph;

  public static void main(String[] args) throws IOException {
    int n = io.nextInt(), m = io.nextInt(), v = io.nextInt();
    graph = new int[n][n];
    while (--m >= 0) {
      int a = io.nextInt(), b = io.nextInt();
      graph[a - 1][b - 1] = 1;
      graph[b - 1][a - 1] = 1;
    }
    dfs(v - 1, new boolean[n]);
    bfs(v - 1, new boolean[n]);
  }

  private static void dfs(int index, boolean[] visited) {
    visited[index] = true;
    io.writeInt(index + 1);
    io.writeBuffer((byte) ' ');
    for (int i = 0; i < graph.length; i++) {
      if (i != index && !visited[i] && graph[index][i] == 1) {
        dfs(i, visited);
      }
    }
  }

  private static void bfs(int index, boolean[] visited) throws IOException {
    io.writeBuffer((byte) '\n');

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(index);
    visited[index] = true;
    while (!queue.isEmpty()) {
      int current = queue.poll();
      io.writeInt(current + 1);
      io.writeBuffer((byte) ' ');
      for (int i = 0; i < graph.length; i++) {
        if (i != current && graph[current][i] == 1 && !visited[i]) {
          queue.offer(i);
          visited[i] = true;
        }
      }
    }
    io.flushAndClose();
  }
}

/*
time complexity
O(N^3)

critical point
DFS, BFS 이해
인접 행렬 대신 인접 리스트 구현 시 효율성 향상 가능 ?!

reference
https://www.acmicpc.net/problem/1260
*/
