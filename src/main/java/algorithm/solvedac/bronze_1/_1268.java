package algorithm.solvedac.bronze_1;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 임시 반장 정하기
 */
public class _1268 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), grade = 5;
    int[][] students = new int[n][grade];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < grade; j++) {
        students[i][j] = nextInt();
      }
    }

    boolean[][] relations = new boolean[n][n];
    for (int i = 0; i < grade; i++) {
      for (int j = 0; j < n - 1; j++) {
        int current = students[j][i];
        for (int k = j + 1; k < n; k++) {
          if (current == students[k][i]) {
            relations[j][k] = true;
            relations[k][j] = true;
          }
        }
      }
    }

    int max = 0, maxIndex = 0;
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = 0; j < n; j++) {
        if (relations[i][j]) {
          ++sum;
        }
      }
      if (max < sum) {
        max = sum;
        maxIndex = i;
      }
    }

    System.out.println(maxIndex + 1);
  }
}

/*
time complexity
O(n^2)

critical point
같은 반 관계 배열

reference
https://www.acmicpc.net/problem/1268
*/
