package algorithm.baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 숫자의 합
 */
public class _11720 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    char[] chars = br.readLine().toCharArray();
    int sum = 0;
    for (char c : chars) {
      sum += (c - '0');
    }

    System.out.println(sum);
  }
}