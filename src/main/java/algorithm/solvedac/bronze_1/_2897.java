package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 몬스터 트럭
 */
public class _2897 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int row = Integer.parseInt(s[0]), col = Integer.parseInt(s[1]);
    char[][] map = new char[row][col];
    for (int i = 0; i < row; i++) {
      String line = br.readLine();
      for (int j = 0; j < col; j++) {
        map[i][j] = line.charAt(j);
      }
    }

    int[] score = new int[5];
    for (int i = 0; i < row - 1; i++) {
      for (int j = 0; j < col - 1; j++) {
        char c1 = map[i][j];
        char c2 = map[i][j + 1];
        char c3 = map[i + 1][j];
        char c4 = map[i + 1][j + 1];
        if (c1 == '#' || c2 == '#' || c3 == '#' || c4 == '#') {
          continue;
        }

        ++score[getCarCount(c1, c2, c3, c4)];
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i : score) {
      sb.append(i).append("\n");
    }
    System.out.print(sb);
  }

  private static int getCarCount(char c1, char c2, char c3, char c4) {
    int count = 0;
    count = c1 == 'X' ? count + 1 : count;
    count = c2 == 'X' ? count + 1 : count;
    count = c3 == 'X' ? count + 1 : count;
    count = c4 == 'X' ? count + 1 : count;
    return count;
  }
}

/*
time complexity

critical point

reference
https://www.acmicpc.net/problem/2897
*/
