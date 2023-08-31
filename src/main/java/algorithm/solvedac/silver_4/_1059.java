package algorithm.solvedac.silver_4;

import java.io.IOException;
import java.util.Arrays;

import algorithm.util.FastIO;

/**
 * 좋은 구간
 */
public class _1059 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int[] array = new int[io.nextInt()];
    int length = array.length;
    for (int i = 0; i < length; i++) {
      array[i] = io.nextInt();
    }
    Arrays.sort(array);

    int n = io.nextInt();
    if (n >= array[length - 1] || Arrays.binarySearch(array, n) >= 0) {
      System.out.println(0);
      return;
    }

    int index = 0;
    while (index < length && array[index] < n) {
      ++index;
    }

    int from = index == 0 ? 1 : array[index - 1] + 1;
    int to = array[index] - 1;
    System.out.println((to - n) * (n - from + 1) + n - from);
  }
}

/*
time complexity
O(NlogN)

critical point
1. 구해야 하는 범위를 둘로 나눔 (source ~ n), (n+1 ~ target)
source n보다 작은 수 중 가장 큰 수
target n보다 큰 수 중 가장 작은 수
2. 두 범위를 곱하여 n을 포함 하는 범위의 수를 구함
3. source ~ n 까지 범위의 경우의 수를 구함 (반드시 n을 포함 해야 하므로 n - source - 1)

reference
https://www.acmicpc.net/problem/1059
*/
