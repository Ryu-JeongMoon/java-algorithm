package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 캥거루 세마리
 */
public class _2965 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int a = Integer.parseInt(s[0]);
    int b = Integer.parseInt(s[1]);
    int c = Integer.parseInt(s[2]);

    System.out.println(Math.max(b - a, c - b) - 1);
  }
}

/*
time complexity
단순 뺄셈이므로 O(1)

critical point
두 캥거루 사이로만 이동할 수 있으므로 -1 필요, 최대 이동 횟수를 구해야 함

reference
https://www.acmicpc.net/problem/2965
 */