package algorithm.baekjoon.math_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 벌집
 */
public class _2292 {

  public static void main(String[] args) throws IOException {
    int i = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
    if (i == 1) {
      System.out.println(1);
      return;
    }

    int count = 2, sum = 1;
    while (true) {
      int arithmeticSequence = (count - 1) * 6;
      if (i <= sum + arithmeticSequence) {
        System.out.println(count);
        break;
      } else {
        sum += arithmeticSequence;
        count++;
      }
    }
  }
}

/*
다시 풀어보기
 */
