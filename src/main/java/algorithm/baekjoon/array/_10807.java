package algorithm.baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 개수 세기
 */
public class _10807 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] splittedNumbers = br.readLine().split(" ");
    int[] ints = new int[201];
    for (int i = 0; i < n; i++) {
      ints[100 + Integer.parseInt(splittedNumbers[i])]++;
    }
    int v = Integer.parseInt(br.readLine());
    System.out.println(ints[100 + v]);
  }
}
