package algorithm.baekjoon.math_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 부녀회장이 될테야
 */
public class _2775 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[][] arr = new int[15][15];
    for (int i = 0; i < 15; i++) {
      arr[0][i] = i + 1;
      arr[i][0] = 1;
    }
    for (int i = 1; i < 15; i++) {
      for (int j = 1; j < 15; j++) {
        arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
      }
    }

    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      int k = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      bw.write(arr[k][n - 1] + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}

/*
2
1
3
2
3
일일이 더하는 수밖에?
 */