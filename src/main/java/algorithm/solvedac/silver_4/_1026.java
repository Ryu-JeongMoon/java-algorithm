package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 보물
 */
public class _1026 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] first = new int[n], second = new int[n];
    String[] s1 = br.readLine().split(" "), s2 = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      first[i] = Integer.parseInt(s1[i]);
      second[i] = Integer.parseInt(s2[i]);
    }
    Arrays.sort(first);
    Arrays.sort(second);
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += first[i] * second[n - i - 1];
    }
    System.out.println(sum);
  }
}

/*
time complexity
O(NlogN)

critical point
S = A[0] × B[0] + ... + A[N-1] × B[N-1]

reference
https://www.acmicpc.net/problem/1026
 */