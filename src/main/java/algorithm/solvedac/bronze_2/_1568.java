package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 새
 */
public class _1568 {

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
    int counter = 1, time = 0;
    while (n > 0) {
      if (n < counter) {
        counter = 1;
      }
      n -= counter++;
      ++time;
    }
    System.out.println(time);
  }
}

/*
time complexity
입력값에 비례해 돌려야 하므로 O(n)

critical point
새의 수 N은 10^9보다 작거나 같은 자연수, Integer 범위 내에 있다

reference
https://www.acmicpc.net/problem/1568
 */
