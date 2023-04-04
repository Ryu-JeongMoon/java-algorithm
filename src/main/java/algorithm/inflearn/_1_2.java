package algorithm.inflearn;

import java.util.Arrays;

/**
 * 청소
 */
public class _1_2 {

  private static final int[] ROWS = { 0, 1, 0, -1 };
  private static final int[] COLUMNS = { 1, 0, -1, 0 };

  public static void main(String[] args) {
    int[][] arr1 = {
      { 0, 0, 0, 0, 0 },
      { 0, 1, 1, 0, 0 },
      { 0, 0, 0, 0, 0 },
      { 1, 0, 1, 0, 1 },
      { 0, 0, 0, 0, 0 } };

    int[][] arr2 = {
      { 0, 0, 0, 1, 0, 1 },
      { 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 1 },
      { 1, 1, 0, 0, 1, 0 },
      { 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0 } };

    int[][] arr3 = {
      { 0, 0, 1, 0, 0 },
      { 0, 1, 0, 0, 0 },
      { 0, 0, 0, 0, 0 },
      { 1, 0, 0, 0, 1 },
      { 0, 0, 0, 0, 0 } };

    System.out.println(Arrays.toString(solution2(arr1, 10)));
    System.out.println(Arrays.toString(solution2(arr2, 20)));
    System.out.println(Arrays.toString(solution2(arr3, 25)));
  }

  public static int[] solution1(int[][] board, int time) {
    int[] answer = new int[2];
    int direction = 0, rowIndex = 0, columnIndex = 0;
    while (--time >= 0) {
      if (direction == 0 && columnIndex + 1 < board[0].length && board[rowIndex][columnIndex + 1] == 0) {
        ++columnIndex;
      } else if (direction == 1 && rowIndex + 1 < board.length && board[rowIndex + 1][columnIndex] == 0) {
        ++rowIndex;
      } else if (direction == 2 && columnIndex - 1 >= 0 && board[rowIndex][columnIndex - 1] == 0) {
        --columnIndex;
      } else if (direction == 3 && rowIndex - 1 >= 0 && board[rowIndex - 1][columnIndex] == 0) {
        --rowIndex;
      } else {
        direction = (direction + 1) % 4;
      }
    }
    answer[0] = rowIndex;
    answer[1] = columnIndex;
    return answer;
  }

  public static int[] solution2(int[][] board, int time) {
    int[] answer = new int[2];
    int direction = 0, row = 0, column = 0;
    while (--time >= 0) {
      int newRow = row + ROWS[direction];
      int newColumn = column + COLUMNS[direction];
      if (newRow < 0 || newRow >= board.length || newColumn < 0 || newColumn >= board[0].length || board[newRow][newColumn] == 1) {
        direction = (direction + 1) % 4;
      } else {
        row = newRow;
        column = newColumn;
      }
    }
    answer[0] = row;
    answer[1] = column;
    return answer;
  }
}

/*
time complexity
O(n)

critical point
길이 제한과 한 칸 앞서 있는 곳에 장애물이 있는지 확인해야 함

solution1
방향을 나타내는 변수를 int direction 으로 선언 후
인덱스가 범위 값을 벗어나는지와 함께 매 조건 마다 판별

solution2
방향을 나타내는 변수를 ROWS, COLUMNS 배열로 미리 선언
방향의 전환은 (ROWS, COLUMNS 배열 인덱스 + 1) % 4로 변경

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=149826
 */