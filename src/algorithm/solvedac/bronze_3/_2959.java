package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 거북이
 */
public class _2959 {

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    int[] arr = new int[4];
    for (int i = 0; i < 4; i++) {
      arr[i] = Integer.parseInt(s[i]);
    }
    Arrays.sort(arr);
    System.out.println(arr[0] * arr[2]);
  }
}

/*
time complexity
입력값 개수 고정이므로 O(1)

critical point
직사각형이 만들어지기 위해서 가장 작은 길이로 높이, 세번째 길이로 너비를 만들어야 함

reference
https://www.acmicpc.net/problem/2959
 */