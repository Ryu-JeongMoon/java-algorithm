package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 체스판 다시 칠하기
 */
public class _1018 {

  public static final int SIZE_OF_BOARD = 8;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] lengthAndBreadth = br.readLine().split(" ");
    int length = Integer.parseInt(lengthAndBreadth[0]);
    int breadth = Integer.parseInt(lengthAndBreadth[1]);
    char[][] board = new char[length][breadth];
    for (int i = 0; i < length; i++) {
      String row = br.readLine();
      for (int j = 0; j < row.length(); j++) {
        board[i][j] = row.charAt(j);
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i <= length - SIZE_OF_BOARD; i++) {
      for (int j = 0; j <= breadth - SIZE_OF_BOARD; j++) {
        int count = countDifference(board, i, j);
        min = Math.min(min, Math.min(count, 64 - count));
      }
    }

    System.out.println(min);
  }

  private static int countDifference(char[][] board, int i, int j) {
    char first = board[i][j];
    int sum = 0;
    for (int k = i; k < i + 8; k++) {
      for (int l = j; l < j + 8; l++) {
        if (((k + l) % 2 == 0 && board[k][l] != first) || ((k + l) % 2 != 0 && board[k][l] == first)) {
          ++sum;
        }
      }
    }
    return sum;
  }
}

/*
time complexity
O(n^2)

critical point
첫 문자와의 비교는 행 + 열 번호가 짝수인 경우와 홀수인 경우를 나누어서 생각해야 함
1. (k + l) % 2 == 0 && board[k][l] != first
2. (k + l) % 2 != 0 && board[k][l] == first
B(0,0) W(0,1) B(0,2) ...
W(1,0) B(1,1) W(1,2) ...

reference
https://www.acmicpc.net/problem/1018
*/