package algorithm.solvedac.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 돌 게임 4
 */
public class _9658 {

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
    System.out.println(n % 7 == 1 || n % 7 == 3 ? "CY" : "SK");
  }
}

/*
time complexity
O(N)

critical point
n % 7 == 1 or n % 7 == 3일 때 SK 무조건 패배로 간소화 가능?!

reference
https://www.acmicpc.net/problem/9658
*/
