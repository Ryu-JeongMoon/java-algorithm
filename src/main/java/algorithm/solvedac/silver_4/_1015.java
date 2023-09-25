package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.*;

import java.io.IOException;
import java.util.Arrays;

/**
 * 수열 정렬
 */
public class _1015 {

  public static void main(String[] args) throws IOException {
    int[] array = new int[nextInt()], copy = new int[array.length], result = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      array[i] = nextInt();
    }
    System.arraycopy(array, 0, copy, 0, array.length);
    Arrays.sort(copy);
    boolean[] visited = new boolean[array.length];
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < copy.length; j++) {
        if (array[i] == copy[j]) {
          while (visited[j]) {
            ++j;
          }
          result[i] = j;
          visited[j] = true;
          break;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i : result) {
      sb.append(i).append(" ");
    }
    System.out.println(sb);
  }
}

/*
time complexity
O(N^2)

critical point
동일한 값이 올 때 인덱스 처리 주의

reference
https://www.acmicpc.net/problem/1015
*/
