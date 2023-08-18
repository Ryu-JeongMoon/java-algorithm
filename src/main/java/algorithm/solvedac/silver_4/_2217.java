package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.Arrays;

/**
 * 로프
 */
public class _2217 {

  public static void main(String[] args) throws IOException {
    int[] lopes = new int[nextInt()];
    int length = lopes.length, max = 0;
    for (int i = 0; i < length; i++) {
      lopes[i] = nextInt();
    }
    Arrays.sort(lopes);
    for (int i = length - 1; i >= 0; i--) {
      max = Math.max(max, lopes[i] * (length - i));
    }
    System.out.println(max);
  }
}

/*
time complexity
O(NlogN)

critical point
역순 접근하여 max, previousMax 비교하여 작아지기 max < previousMax인 경우
바로 반환하려 했으나 모든 경우를 살펴볼 필요가 있었음

3 / (4, 5, 11) 의 경우
11 -> 11
5, 11 -> 10
4, 5, 11 -> 12

reference
https://www.acmicpc.net/problem/2217
*/
