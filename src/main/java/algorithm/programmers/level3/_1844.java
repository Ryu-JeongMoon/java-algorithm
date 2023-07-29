package algorithm.programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 게임 맵 최단거리
 */
public class _1844 {

  private static final int[][] DIRECTION = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

  public static void main(String[] args) {
    _1844 instance = new _1844();
    System.out.println(instance.solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 } }));
    System.out.println(instance.solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1 } }));
  }

  public int solution(int[][] maps) {
    int n = maps.length, m = maps[0].length;
    if (n > 2 && m > 2 && maps[n - 1][m - 2] == 0 && maps[n - 2][m - 1] == 0) {
      return -1;
    }

    Queue<State> queue = new LinkedList<>();
    queue.add(new State(0, 0, 1));
    boolean[][] visited = new boolean[n][m];
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      State state = queue.poll();
      for (int[] ints : DIRECTION) {
        int nextX = state.x + ints[0];
        int nextY = state.y + ints[1];
        if (isOutOfMap(nextX, nextY, maps) || maps[nextX][nextY] == 0 || visited[nextX][nextY]) {
          continue;
        }

        if (nextX == n - 1 && nextY == m - 1) {
          return state.step + 1;
        }

        visited[nextX][nextY] = true;
        queue.add(new State(nextX, nextY, state.step + 1));
      }
    }

    return -1;
  }

  private boolean isOutOfMap(int nextX, int nextY, int[][] maps) {
    return nextX < 0 || nextX == maps.length || nextY < 0 || nextY == maps[0].length;
  }

  private static class State {

    private final int x;
    private final int y;
    private final int step;

    private State(int x, int y, int step) {
      this.x = x;
      this.y = y;
      this.step = step;
    }
  }
}

/*
time complexity
O(NM)

critical point
최단 거리는 BFS

reference
https://programmers.co.kr/learn/courses/30/lessons/1844
*/
