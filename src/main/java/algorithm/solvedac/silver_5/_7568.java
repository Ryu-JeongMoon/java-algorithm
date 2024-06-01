package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 덩치
 */
public class _7568 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int[][] people = new int[n][2];

    for (int i = 0; i < n; i++) {
      people[i][0] = nextInt();
      people[i][1] = nextInt();
    }

    int[] scores = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i != j && people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
          ++scores[i];
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int score : scores) {
      sb.append(score + 1).append(' ');
    }
    System.out.println(sb);
  }
}

/*
time complexity
O(N^2)

critical point
중복 등수 X, 자신보다 더 큰 덩치의 사람이 k명 이라면 그 사람의 덩치 등수는 k+1이 된다

reference
https://www.acmicpc.net/problem/7568
*/
