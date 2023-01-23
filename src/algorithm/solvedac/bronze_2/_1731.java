package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 추론
 */
public class _1731 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()),
      previous = Integer.parseInt(br.readLine()),
      current = Integer.parseInt(br.readLine()),
      next = Integer.parseInt(br.readLine());
    int diff1 = current - previous, diff2 = current / previous;
    if (diff1 == next - current) {
      System.out.println(previous + diff1 * n);
    } else if (diff2 == next / current) {
      System.out.println(previous * (long) Math.pow(diff2, n));
    }
  }
}

/*
time complexity
O(1)

critical point
3개의 수만 받아서 등차 수열인지 등비 수열인지 판단
등비 수열일 경우 int 범위 초과 가능

reference
https://www.acmicpc.net/problem/1731
 */