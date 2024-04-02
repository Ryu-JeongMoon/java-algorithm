package algorithm.solvedac.bronze_2;

import static algorithm.util.SimpleIntReader.nextIntWithNegative;

import java.io.IOException;
import java.util.Arrays;

/**
 * 수 정렬하기
 */
public class _2750 {

  public static void main(String[] args) throws IOException {
    int[] numbers = new int[nextIntWithNegative()];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = nextIntWithNegative();
    }
    Arrays.sort(numbers);
    StringBuilder sb = new StringBuilder();
    for (int number : numbers) {
      sb.append(number).append("\n");
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(NlogN)

critical point
DualPivotQuicksort 알아보기

reference
https://www.acmicpc.net/problem/2750
*/
