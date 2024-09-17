package algorithm.leetcode.medium;

/**
 * Valid Sudoku
 */
public class _36 {

  public static void main(String[] args) {
    _36 instance = new _36();

    char[][] board1 = {
      {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
      {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
      {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
      {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
      {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
      {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
      {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
      {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
      {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    System.out.println(instance.isValidSudoku(board1));

    char[][] board2 = {
      {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
      {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
      {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
      {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
      {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
      {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
      {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
      {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
      {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    System.out.println(instance.isValidSudoku(board2));
  }

  public boolean isValidSudoku(char[][] board) {
    int length = board.length, boxUnit = 3;
    for (int i = 0; i < length; i++) {
      if (isDuplicatedInRange(board, 0, board.length, i, i + 1)) {
        return false;
      }
    }

    for (int i = 0; i < length; i++) {
      if (isDuplicatedInRange(board, i, i + 1, 0, board.length)) {
        return false;
      }

      if (i % boxUnit == 0) {
        for (int j = 0; j < length; j += boxUnit) {
          if (isDuplicatedInRange(board, i, i + boxUnit, j, j + boxUnit)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private boolean isDuplicatedInRange(char[][] board, int rowStart, int rowEnd, int colStart, int colEnd) {
    int[] duplicates = new int[board.length];
    int index = 0;
    for (int i = rowStart; i < rowEnd; i++) {
      for (int j = colStart; j < colEnd; j++, index++) {
        char current = board[i][j];
        if (current != '.' && duplicates[current - '0' - 1]++ != 0) {
          return true;
        }
      }
    }
    return false;
  }
}

/*
time complexity
O(N^2)

critical point
세 메서드 구현 후 공통화
1. row
2. col
3. box

reference
https://leetcode.com/problems/valid-sudoku/
*/
