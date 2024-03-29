package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.Arrays;

/**
 * 삼각형 만들기
 */
public class _1448 {

  public static void main(String[] args) throws IOException {
    int[] straws = new int[nextInt()];
    for (int i = 0; i < straws.length; i++) {
      straws[i] = nextInt();
    }

    Arrays.sort(straws);
    for (int i = straws.length - 1; i >= 2; i--) {
      if (straws[i] < straws[i - 1] + straws[i - 2]) {
        System.out.println(straws[i] + straws[i - 1] + straws[i - 2]);
        return;
      }
    }
    System.out.println(-1);
  }
}

/*
time complexity
O(NlogN)

critical point
1. 삼각형의 성립 조건, biggest side < sum of other two sides
2. 개수가 많아질수록 정렬 부하로 인해 느림

reference
https://www.acmicpc.net/problem/1448
*/
