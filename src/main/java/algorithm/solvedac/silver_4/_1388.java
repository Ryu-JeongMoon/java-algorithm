package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 바닥 장식
 */
public class _1388 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int row = Integer.parseInt(s[0]), col = Integer.parseInt(s[1]);
    char[][] board = new char[row][col];
    for (int i = 0; i < row; i++) {
      String decorations = br.readLine();
      for (int j = 0; j < col; j++) {
        board[i][j] = decorations.charAt(j);
      }
    }

    int count = 0;
    boolean[][] visited = new boolean[row][col];
    for (int i = 0; i < row; i++) {
      char previous = 0;
      for (int j = 0; j < col; j++) {
        char currentRow = board[i][j];
        if (visited[i][j]) {
          previous = currentRow;
          continue;
        }
        visited[i][j] = true;

        if (currentRow == '-' && currentRow != previous) {
          ++count;
          previous = currentRow;
        } else if (currentRow == '|') {
          ++count;
          previous = currentRow;
          for (int k = i + 1; k < row; k++) {
            if (visited[k][j]) {
              continue;
            } else if (board[k][j] != previous) {
              break;
            }

            visited[k][j] = true;
          }
        }
      }
    }

    System.out.println(count);
  }
}

/*
time complexity
O(row^2*col)

critical point
하나의 행에 대한 순회를 하며 '|'를 만나는 경우, 해당 열에 대해서도 순회

reference
https://www.acmicpc.net/problem/1388
*/
