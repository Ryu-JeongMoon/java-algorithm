package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팩토리얼 0의 개수
 */
public class _1676 {

  public static void main(String[] args) throws IOException {
    int value = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
    int result = 0;
    while (value != 0) {
      result += (value / 5);
      value /= 5;
    }
    System.out.println(result);
  }
}

/*
time complexity
O(logN)

critical point
자리수가 올라가려면 2 * 5가 필요
n = 5^k * m 라고 할 때 k에 따라 결정

reference
https://www.acmicpc.net/problem/1676
 */