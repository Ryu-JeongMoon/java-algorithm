package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 쉽게 푸는 문제
 */
public class _1292 {

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    int index = 1;
    int[] arr = new int[1036];
    for (int i = 1; i <= 45; i++) {
      for (int j = 0; j < i; j++, index++) {
        arr[index] = arr[index - 1] + i;
      }
    }
    System.out.println(arr[Integer.parseInt(s[1])] - arr[Integer.parseInt(s[0]) - 1]);
  }
}

/*
time complexity
항상 1035까지만 반복 O(1)

critical point
1. 구간을 구할 때 항상 1,000을 넘지 않음 1 <= A <= B <= 1000
2. 최대 인덱스 구하기 위해 1,000에 근접한 반복 개수의 합을 구함 -> n*(n+1)/2 =~ 1035
3. 3~7 구간 사이의 합을 구하려면 (1~7까지의 합)에서 (1~2까지의 합)을 빼면 됨
4. 따라서 큰 값은 마지막 범위를 포함해야 하므로 arr[b], 작은 값은 마지막 범위를 빼야 하므로 arr[a-1]

reference
https://www.acmicpc.net/problem/1292
 */
