package algorithm.baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 킹, 퀸, 룩, 비숍, 나이트, 폰
 */
public class _3003 {

  private static final int[] PIECES = { 1, 1, 2, 2, 2, 8 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] pieces = Arrays.stream(br.readLine().split(" "))
      .mapToInt(Integer::parseInt)
      .toArray();

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < PIECES.length; i++) {
      builder.append(PIECES[i] - pieces[i]).append(" ");
    }

    System.out.println(builder);
  }
}

/*
Stream 변환이 시간 넘 많이 잡아먹는 듯
매번 Integer.parseInt 연산 해주는 게 더 빠름
 */