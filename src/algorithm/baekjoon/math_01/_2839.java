package algorithm.baekjoon.math_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 설탕 배달
 */
public class _2839 {

  public static void main(String[] args) throws IOException {
    int i = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

    if (i % 5 == 0) {
      System.out.println(i / 5);
    } else if (i % 5 == 1) {
      System.out.println(i / 5 + 1);
    } else if (i % 5 == 2) {
      if (i < 12) {
        System.out.println(-1);
      } else {
        System.out.println(i / 5 + 2);
      }
    } else if (i % 5 == 3) {
      System.out.println(i / 5 + 1);
    } else if (i % 5 == 4) {
      if (i < 9) {
        System.out.println(-1);
      } else {
        System.out.println(i / 5 + 2);
      }
    }
  }
}

/*
i % 5 == 2
2, 7, 12, 17, 22, 27, 32, 37 ..
17 = 12 + 5, 22 = 12 + 10 ...

i % 5 == 4
4, 9, 14, 19, 24, 29 ..
14 = 9 + 5, 19 = 9 + 10, 24 = 9 + ...

n -> 5 x a + 3 x b를 만족하는 a, b에 대하여 a + b를 구하라
a + b가 최소가 되어야 하므로 5로 나눈 나머지에 대해서만 생각해서 a가 최대가 되게 해야 함
 */