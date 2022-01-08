package algorithm.baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 숫자의 개수
 */
public class _2577 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int sum = 1;
    for (int i = 0; i < 3; i++) {
      sum *= Integer.parseInt(br.readLine());
    }

    String numbers = sum + "";
    char[] chars = numbers.toCharArray();

    int[] ints = new int[10];
    for (char c : chars) {
      ints[c - '0']++;
    }

    for (int i : ints) {
      System.out.println(i);
    }
  }
}