package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 직사각형 네개의 합집합의 면적 구하기
 */
public class _2669 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean[][] map = new boolean[101][101];
    int area = 0;
    for (int i = 0; i < 4; i++) {
      String[] s = br.readLine().split(" ");
      for (int j = Integer.parseInt(s[0]); j < Integer.parseInt(s[2]); j++) {
        for (int k = Integer.parseInt(s[1]); k < Integer.parseInt(s[3]); k++) {
          if (!map[j][k]) {
            map[j][k] = true;
            ++area;
          }
        }
      }
    }
    System.out.println(area);
  }
}

/*
time complexity
O(n^2)

critical point
좌표 자체를 1x1 면적으로 생각하고 입력과 동시에 면적 증가

reference
https://www.acmicpc.net/problem/2669
 */