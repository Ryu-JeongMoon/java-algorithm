package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 줄 세우기
 */
public class _1681 {

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    int n = Integer.parseInt(s[0]), l = Integer.parseInt(s[1]), index = 0, count = 1;
    int[] arr = new int[n];
    while (arr[n - 1] == 0) {
      if (notContains(count++, l)) {
        arr[index++] = count - 1;
      }
    }
    System.out.println(arr[n - 1]);
  }

  private static boolean notContains(int m, int i) {
    while (m != 0) {
      if (m % 10 == i) {
        return false;
      }
      m /= 10;
    }
    return true;
  }
}

/*
time complexity
O(n)

critical point
마지막 자리수와 L로 주어진 수 비교 후 m != 10으로 맨 뒷자리 잘라가며 비교

reference
https://www.acmicpc.net/problem/1681
 */