package algorithm.programmers.level2;

import java.util.Arrays;

/**
 * 삼각 달팽이
 */
public class _68645 {

  private static final int[] ROW = { 1, 0, -1 };
  private static final int[] COL = { 0, 1, -1 };

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(1)));
    System.out.println(Arrays.toString(solution(4)));
    System.out.println(Arrays.toString(solution(5)));
    System.out.println(Arrays.toString(solution(6)));
  }

  public static int[] solution(int n) {
    int[][] map = new int[n][n];
    int total = n * (n + 1) / 2;
    int x = 0, y = 0, direction = 0;

    for (int i = 0; i < total; i++) {
      map[x][y] = i + 1;

      int newX = x + ROW[direction];
      int newY = y + COL[direction];
      while (i != total - 1 && (isOutOfMap(n, x, newX, newY) || (map[newX][newY] != 0))) {
        direction = (direction + 1) % 3;
        newX = x + ROW[direction];
        newY = y + COL[direction];
      }

      x = newX;
      y = newY;
    }

    int[] answer = new int[total];
    int index = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i + 1; j++) {
        answer[index++] = map[i][j];
      }
    }
    return answer;
  }

  private static boolean isOutOfMap(int n, int level, int newX, int newY) {
    return n <= newX || newX < 0 || level + 1 <= newY || newY < 0;
  }
}

/*
4	[1,2,9,3,10,8,4,5,6,7]
5	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
6	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]

time complexity
O(n^2)

critical point
while (isOutOfMap(n, x, newX, newY) || (map[newX][newY] != 0 && i != total - 1))
1. 주어진 범위를 벗어났는지
2. 주어진 범위 안에 있더라도 값이 이미 존재하는지
3. 마지막에는 사방에 값이 이미 존재하므로 스킵해야 함

1. while (isOutOfMap(n, x, newX, newY) || (map[newX][newY] != 0 && i != total - 1))
2. while (i != total - 1 && (isOutOfMap(n, x, newX, newY) || (map[newX][newY] != 0)))
i != total - 1 조건을 별도로 빼어 n == 1에 대한 예외 처리를 하지 않아도 됨

reference
https://programmers.co.kr/learn/courses/30/lessons/68645
*/
