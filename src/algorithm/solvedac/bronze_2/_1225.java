package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이상한 곱셈
 */
public class _1225 {

  public static void main(String[] args) throws IOException {
    String[] reader = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    long[] a = { 0, 0 };
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < reader[i].length(); j++) {
        a[i] += (reader[i].charAt(j) - 48);
      }
    }
    System.out.print(a[0] * a[1]);
  }
}

/*
time complexity
입력값의 자릿수에 따라 반복 횟수가 달라짐 O(n.length)

critical point
주어지는 두 수는 모두 10,000자리를 넘지 않는 음이 아닌 정수, 자릿수 주의

reference
https://www.acmicpc.net/problem/1225
 */