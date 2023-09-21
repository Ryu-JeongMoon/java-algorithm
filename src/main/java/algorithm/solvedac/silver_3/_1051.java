package algorithm.solvedac.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 숫자 정사각형
 */
public class _1051 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(tokenizer.nextToken()), m = Integer.parseInt(tokenizer.nextToken());
    char[][] square = new char[n][m];
    for (int i = 0; i < n; i++) {
      square[i] = br.readLine().toCharArray();
    }

    int currentMax = 0, smaller = Math.min(n, m);
    outer:
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (currentMax == smaller) {
          break outer;
        }

        for (int k = currentMax + 1; k <= smaller; k++) {
          if (i + k >= n || j + k >= m) {
            break;
          }

          if (square[i][j] == square[i + k][j] && square[i + k][j] == square[i + k][j + k]
            && square[i + k][j + k] == square[i][j + k] && square[i][j + k] == square[i][j]) {
            currentMax = k;
          }
        }
      }
    }
    System.out.println(++currentMax * currentMax);
  }
}

/*
time complexity
O(n * m)

critical point
currentMax ~ smaller 까지만 탐색, 효율 최적화

reference
https://www.acmicpc.net/problem/1051
*/
