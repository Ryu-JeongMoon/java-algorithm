package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 누울 자리를 찾아라
 */
public class _1652 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    char[][] room = new char[n][n];
    int width = 0, height = 0;
    for (int i = 0; i < n; i++) {
      String row = br.readLine();
      for (int j = 0; j < row.length(); j++) {
        room[j][i] = row.charAt(j);
      }
    }

    boolean checked;
    for (int i = 0; i < n; i++) {
      checked = false;
      for (int j = 0; j < n - 1; j++) {
        if (!checked && room[j][i] == '.' && room[j + 1][i] == '.') {
          ++width;
          checked = true;
        } else if (room[j][i] == 'X') {
          checked = false;
        }
      }

      checked = false;
      for (int j = 0; j < n - 1; j++) {
        if (!checked && room[i][j] == '.' && room[i][j + 1] == '.') {
          ++height;
          checked = true;
        } else if (room[i][j] == 'X') {
          checked = false;
        }
      }
    }

    System.out.println(width + " " + height);
  }
}

/*
time complexity
O(N^2)

critical point
한 줄에 빈칸 2개 이상이며 각 빈칸 사이에 짐으로 막혀있다면 두 자리 이상 누울 수 있음
..X.. -> 누울 자리 2 군데

[Input]
5
.....
.....
..X..
.....
.....

[Output]
6 6

[Wrong Answer]
5 5

reference
https://www.acmicpc.net/problem/1652
 */