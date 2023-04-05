package algorithm.inflearn;

/**
 * 잃어버린 강아지
 */
public class _1_3 {

  private static final int[] ROWS = { -1, 0, 1, 0 };
  private static final int[] COLUMNS = { 0, 1, 0, -1 };
  private static int ROW_LENGTH = 0;
  private static int COL_LENGTH = 0;

  public static void main(String[] args) {
    int[][] arr1 = {
      { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
      { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 1, 0, 0, 0, 2, 0, 0 },
      { 1, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
      { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 3, 0, 0, 0, 1 },
      { 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 },
      { 0, 1, 0, 1, 0, 0, 0, 0, 0, 0 } };

    int[][] arr2 = {
      { 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
      { 0, 0, 1, 1, 0, 0, 0, 1, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 },
      { 1, 0, 0, 0, 0, 0, 1, 0, 1, 0 },
      { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 1, 0, 0, 0, 0, 0, 2, 1 },
      { 0, 0, 0, 1, 0, 1, 0, 0, 0, 1 },
      { 0, 1, 0, 1, 0, 0, 0, 0, 0, 3 } };

    System.out.println(solution(arr1));
    System.out.println(solution(arr2));
  }

  public static int solution(int[][] board) {
    ROW_LENGTH = board.length;
    COL_LENGTH = board[0].length;

    int[][] ownerAndDog = findOwnerAndDog(board);
    int ownerDirection = 0, dogDirection = 0;

    int answer = 0;
    while (++answer < 10_000) {
      int newOwnerRow = ownerAndDog[0][0] + ROWS[ownerDirection];
      int newOwnerCol = ownerAndDog[0][1] + COLUMNS[ownerDirection];
      int newDogRow = ownerAndDog[1][0] + ROWS[dogDirection];
      int newDogCol = ownerAndDog[1][1] + COLUMNS[dogDirection];

      if (isNotInBoard(newOwnerRow, newOwnerCol) || board[newOwnerRow][newOwnerCol] == 1) {
        ownerDirection = (ownerDirection + 1) % 4;
      } else {
        ownerAndDog[0][0] = newOwnerRow;
        ownerAndDog[0][1] = newOwnerCol;
      }

      if (isNotInBoard(newDogRow, newDogCol) || board[newDogRow][newDogCol] == 1) {
        dogDirection = (dogDirection + 1) % 4;
      } else {
        ownerAndDog[1][0] = newDogRow;
        ownerAndDog[1][1] = newDogCol;
      }

      if (ownerAndDog[0][0] == ownerAndDog[1][0] && ownerAndDog[0][1] == ownerAndDog[1][1]) {
        break;
      }
    }

    return answer != 10_000 ? answer : 0;
  }

  private static int[][] findOwnerAndDog(int[][] board) {
    int[][] ownerAndDog = new int[2][2];
    // const
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 2) {
          ownerAndDog[0][0] = i;
          ownerAndDog[0][1] = j;
        } else if (board[i][j] == 3) {
          ownerAndDog[1][0] = i;
          ownerAndDog[1][1] = j;
        }
      }
    }
    return ownerAndDog;
  }

  private static boolean isNotInBoard(int row, int col) {
    return row < 0 || row >= ROW_LENGTH || col < 0 || col >= COL_LENGTH;
  }
}

/*
time complexity
O(N)

critical point
1-2와 동일 개념

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=149828
 */