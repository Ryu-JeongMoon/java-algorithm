package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 도미노
 */
public class _2921 {

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
    int sum = 0;
    for (int i = 0; i <= n; i++) {
      for (int j = i; j <= n; j++) {
        sum += (i + j);
      }
    }
    System.out.println(sum);
  }
}

/*
time complexity
O(n^2)

critical point
반복문 없이 상수로 풀 수 있음?!
개선해볼 것

reference
https://www.acmicpc.net/problem/2921
 */