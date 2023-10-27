package algorithm.solvedac.silver_3;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * N과 M (1)
 */
public class _15649_2 {

  private static FastIO io;
  private static int total, target;
  private static char[] buffer;
  private static boolean[] visited;

  public static void main(String[] args) throws IOException {
    io = new FastIO();
    total = io.nextInt();
    target = io.nextInt();

    visited = new boolean[total];
    buffer = new char[target * 2];
    buffer[buffer.length - 1] = '\n';
    for (int i = 1; i < buffer.length - 1; i += 2) {
      buffer[i] = ' ';
    }

    dfs(0);
    io.flushAndClose();
  }

  private static void dfs(int current) {
    if (current == target) {
      for (char b : buffer) {
        io.writeBuffer((byte) b);
      }
      return;
    }

    for (int i = 0; i < total; i++) {
      if (!visited[i]) {
        visited[i] = true;
        buffer[current * 2] = (char) (i + 1 + '0');
        dfs(current + 1);
        visited[i] = false;
      }
    }
  }
}

/*
time complexity
O(N^M)

critical point
출력할 내용이 정해져 있다면 ' ', '\n' 같은 문자들은 미리 만들어 둘 수 있다 ?!
dfs에서 depth (or step) 주의

reference
https://www.acmicpc.net/problem/15649
*/
