package algorithm.baekjoon.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 한수
 */
public class _1065 {

  private static final int[] HANSOO = {
    111, 123, 135, 147, 159, 210, 222, 234, 246, 258,
    321, 333, 345, 357, 369, 420, 432, 444, 456, 468,
    531, 543, 555, 567, 579, 630, 642, 654, 666, 678,
    741, 753, 765, 777, 789, 840, 852, 864, 876, 888,
    951, 963, 975, 987, 999
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int i = Integer.parseInt(br.readLine());
    long start = System.nanoTime();

    if (i <= 99) {
      System.out.println(i);
      return;
    }

    for (int j = 0; j < HANSOO.length; j++) {
      if (i < HANSOO[j]) {
        System.out.println(99 + j);
        return;
      }
    }

    System.out.println(144);
    System.out.println(System.nanoTime() - start);
  }
}

/*
캐싱하는게 더 빠를 것 같아서 했는데 brute-force 보다 느린 결과 나옴?!
메모리 더 먹어도 얘가 더 빠를 수 밖에 없지 않남??
 */