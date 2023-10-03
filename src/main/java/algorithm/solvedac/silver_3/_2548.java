package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.*;

import java.io.IOException;
import java.util.Arrays;

/**
 * 대표 자연수
 */
public class _2548 {

  public static void main(String[] args) throws IOException {
    int[] numbers = new int[nextInt()];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = nextInt();
    }
    Arrays.sort(numbers);
    System.out.println(numbers[(numbers.length - 1) / 2]);
  }
}

/*
time complexity
O(NlogN)

critical point
정렬 후 중앙값 출력

reference
https://www.acmicpc.net/problem/2548
*/
