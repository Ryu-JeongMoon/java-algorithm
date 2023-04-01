package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 행렬 곱셈
 */
public class _2740 {

  private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    String[] line = READER.readLine().split(" ");
    int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);
    int[][] first = receiveInput(n, new int[n][m]);

    int k = Integer.parseInt(READER.readLine().split(" ")[1]);
    int[][] second = receiveInput(m, new int[m][k]);

    StringBuilder sb = new StringBuilder();
    int[][] result = new int[n][k];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k; j++) {
        for (int l = 0; l < m; l++) {
          result[n - i - 1][j] += (first[n - i - 1][l] * second[m - l - 1][j]);
        }
        // 행 기준 역순 출력
        sb.append(result[n - i - 1][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  private static int[][] receiveInput(int n, int[][] array) throws IOException {
    for (int i = 0; i < n; i++) {
      String[] line = READER.readLine().split(" ");
      for (int j = 0; j < line.length; j++) {
        array[n - i - 1][j] = Integer.parseInt(line[j]);
      }
    }
    return array;
  }
}

/*
time complexity
O(N^3)

critical point
다음과 같이 입력을 받는다면 행렬 곱셈 시 순서가 꼬일 수 있다
n x m, m x k 행렬을 곱해 n x k 행렬을 만든 후 전체 순회를 하면서 출력할 때
0,0 부터가 아닌 n-1,0부터 출력해줘야 함, 즉 행 기준 역순으로 출력
1(2,0) / 2(2,1)
3(1,0) / 4(1,1)
5(0,0) / 6(0,1)

reference
https://www.acmicpc.net/problem/2740
 */