package algorithm.baekjoon.math_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 분수찾기
 */
public class _1193 {

  public static void main(String[] args) throws IOException {
    int x = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

    int first = 0, n = 1;
    while (true) {
      first += n;
      if (x <= first) {
        break;
      }
      n++;
    }

    first -= --n;
    int diff = x - first;
    if (n % 2 != 0) {
      System.out.println((1 + diff) + "/" + (1 + n - diff));
    } else {
      System.out.println((1 + n - diff) + "/" + (1 + diff));
    }
  }
}

/*
등차수열, 분수 자리 지그재그
 */