package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수들의 합 5
 */
public class _2018 {

  public static void main(String[] args) throws IOException {
    simple();
    // complex();
  }

  private static void simple() throws IOException {
    int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
    int ans = 0, t;
    for (int i = 1; (t = i * (i + 1) / 2) <= n; i++) {
      if ((n - t) % i == 0) {
        ans++;
      }
    }
    System.out.println(ans);
  }

  private static void complex() throws IOException {
    int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
    if (n == 1) {
      System.out.println(1);
      return;
    }
    int half = n % 2 == 0 ? n / 2 : n / 2 + 1;
    int sum = 0, count = 1;
    for (int i = 1; i <= half; i++) {
      for (int j = i; j <= half; j++) {
        sum += j;
        if (sum == n) {
          ++count;
        } else if (sum > n) {
          sum = 0;
          break;
        }
      }
    }
    System.out.println(count);
  }
}

/*
time complexity
simple : O(n)
complex: O(n^2)

critical point
simple : (n-t) % i == 0은 n이 i개의 연속된 합으로 나타낼 수 있는지 확인하는 것
complex: 입력으로 1이 오는 경우도 고려해야 함

reference
https://www.acmicpc.net/problem/2018
 */
