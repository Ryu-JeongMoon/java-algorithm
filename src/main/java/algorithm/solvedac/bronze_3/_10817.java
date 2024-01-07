package algorithm.solvedac.bronze_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.Arrays;

/**
 * 세 수
 */
public class _10817 {

  public static void main(String[] args) throws IOException {
    int[] numbers = new int[3];
    for (int i = 0; i < 3; i++) {
      numbers[i] = nextInt();
    }
    Arrays.sort(numbers);
    System.out.println(numbers[1]);
  }
}

/*
time complexity
O(1)

critical point

reference
https://www.acmicpc.net/problem/10817
*/
