package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 투명
 */
public class _1531 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
    int[][] pictures = new int[101][101];
    while (--n >= 0) {
      s = br.readLine().split(" ");
      for (int i = Integer.parseInt(s[0]); i <= Integer.parseInt(s[2]); i++) {
        for (int j = Integer.parseInt(s[1]); j <= Integer.parseInt(s[3]); j++) {
          pictures[i][j] += 1;
        }
      }
    }

    int count = 0;
    for (int i = 1; i < 101; i++) {
      for (int j = 1; j < 101; j++) {
        if (pictures[i][j] > m) {
          ++count;
        }
      }
    }
    System.out.println(count);
  }
}

/*
time complexity
O(N^2)

critical point
100 * 100 = 10,000이므로 brute-force 가능
겹치는 횟수 비교해 그 횟수가 큰 경우에만 count 증가

reference
https://www.acmicpc.net/problem/1531
 */
