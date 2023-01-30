package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 운동
 */
public class _1173 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int N = Integer.parseInt(s[0]);
    int m = Integer.parseInt(s[1]);
    int M = Integer.parseInt(s[2]);
    int T = Integer.parseInt(s[3]);
    int R = Integer.parseInt(s[4]);

    if (m + T > M) {
      System.out.println(-1);
      return;
    }

    int min = 0;
    int pulse = m;
    while (N > 0) {
      if (pulse + T > M) {
        pulse = Math.max(pulse - R, m);
      } else {
        pulse += T;
        --N;
      }
      ++min;
    }
    System.out.println(min);
  }
}

/*
time complexity
운동하는 시간 N에 따라 반복 돌려야 하므로 O(N)

critical point
맥박은 m 이하로 떨어질 수 없으며 운동할 때만 N 값을 줄여야 함

reference
https://www.acmicpc.net/problem/1173
 */