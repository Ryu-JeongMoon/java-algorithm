package algorithm.baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 최댓값
 */
public class _2562 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int max = 0, index = 0;

    for (int i = 1; i < 10; i++) {
      int num = Integer.parseInt(br.readLine());
      if (max < num) {
        max = num;
        index = i;
      }
    }

    System.out.println(max);
    System.out.println(index);
  }
}

/*
java 8로 하면 메모리를 덜 먹네?!
 */