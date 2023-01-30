package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 최댓값
 */
public class _2566 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = 0, row = 0, column = 0, max = 0;
    while (++count < 10) {
      String[] s = br.readLine().split(" ");
      for (int i = 0; i < s.length; i++) {
        int number = Integer.parseInt(s[i]);
        if (max <= number) {
          max = number;
          column = i + 1;
          row = count;
        }
      }
    }
    System.out.println(max + "\n" + row + " " + column);
  }
}

/*
time complexity
O(1)

critical point
반복 조건 주의

reference
https://www.acmicpc.net/problem/2566
 */