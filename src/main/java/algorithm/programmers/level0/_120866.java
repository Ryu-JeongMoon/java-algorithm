package algorithm.programmers.level0;

/**
 * 안전지대
 */
public class _120866 {

  public static void main(String[] args) {
    _120866 instance = new _120866();
    System.out.println(instance.solution(new int[][] {
      { 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0 },
      { 0, 0, 1, 0, 0 },
      { 0, 0, 0, 0, 0 }
    }));

    System.out.println(instance.solution(new int[][] {
      { 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0 },
      { 0, 0, 1, 1, 0 },
      { 0, 0, 0, 0, 0 }
    }));

    System.out.println(instance.solution(new int[][] {
      { 1, 1, 1, 1, 1, 1 },
      { 1, 1, 1, 1, 1, 1 },
      { 1, 1, 1, 1, 1, 1 },
      { 1, 1, 1, 1, 1, 1 },
      { 1, 1, 1, 1, 1, 1 },
      { 1, 1, 1, 1, 1, 1 }
    }));
  }

  private static final int[][] DIRECTIONS = {
    { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }
  };

  public int solution(int[][] board) {
    int n = board.length;
    int answer = n * n;

    boolean[][] visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j] && board[i][j] == 1) {
          visited[i][j] = true;
          answer = markDangerousZone(board, i, j, visited, --answer);
        }
      }
    }

    return answer;
  }

  private int markDangerousZone(int[][] board, int i, int j, boolean[][] visited, int answer) {
    for (int[] direction : DIRECTIONS) {
      int nextX = i + direction[0];
      int nextY = j + direction[1];

      if (!isOutOfMap(board.length, nextX, nextY) && !visited[nextX][nextY] && board[nextX][nextY] != 1) {
        visited[nextX][nextY] = true;
        --answer;
      }
    }
    return answer;
  }

  private boolean isOutOfMap(int n, int x, int y) {
    return x < 0 || x >= n || y < 0 || y >= n;
  }
}

/*
time complexity
O(n^2)

critical point
주변 구역이 1인 경우 방문 생략

reference
https://programmers.co.kr/learn/courses/30/lessons/120866
*/
