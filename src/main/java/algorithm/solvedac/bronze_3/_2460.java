package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 지능형 기차 2
 */
public class _2460 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = 9, sum = 0, max = 0;
    while (--n >= 0) {
      String[] s = br.readLine().split(" ");
      sum += Integer.parseInt(s[1]) - Integer.parseInt(s[0]);
      max = Math.max(max, sum);
    }
    System.out.println(max);
  }
}

/*
time complexity
O(1)

critical point
종착역에서 타는 사람은 없다, 네개의 역을 다 입력 받을 필요 없다

reference
https://www.acmicpc.net/problem/2460
 */