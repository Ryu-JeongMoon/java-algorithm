package algorithm.inflearn;

import java.util.Arrays;

/**
 * 좌석 번호
 */
public class _1_4 {

  private static final int[] ROWS = { 1, 0, -1, 0 };
  private static final int[] COLS = { 0, 1, 0, -1 };

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(6, 5, 12)));
    System.out.println(Arrays.toString(solution(6, 5, 20)));
    System.out.println(Arrays.toString(solution(6, 5, 30)));
    System.out.println(Arrays.toString(solution(6, 5, 31)));
  }

  public static int[] solution(int col, int row, int turn) {
    if (turn > col * row) {
      return new int[] { 0, 0 };
    }

    int resultRow = 0, resultCol = 0, direction = 0;
    boolean[][] visited = new boolean[row][col];
    visited[0][0] = true;
    while (turn > 1) {
      int newRow = resultRow + ROWS[direction];
      int newCol = resultCol + COLS[direction];

      if (newRow == row || newRow < 0 || newCol == col || newCol < 0 || visited[newRow][newCol]) {
        direction = (direction + 1) % 4;
      } else {
        --turn;
        resultRow = newRow;
        resultCol = newCol;
        visited[resultRow][resultCol] = true;
      }
    }
    return new int[] { resultCol + 1, resultRow + 1 };
  }
}

/*
time complexity
O(N)

critical point
1. visited[0][0] = true, while (turn > 1) 조건을 줌으로써 (1,1) 좌석 포함
2. 인덱스 0부터 계산하여 출력 시 + 1
3. 방문 여부 체크 필요
4. 가로 x, 세로 y일 때 90도 전환해서 보면 x행 y열의 배열로 표현 가능?!

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=149830
 */
