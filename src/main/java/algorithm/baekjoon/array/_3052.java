package algorithm.baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 나머지
 */
public class _3052 {

  public static void main(String[] args) throws IOException {
    int[] remains = new int[43];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < 10; i++)
      remains[Integer.parseInt(br.readLine()) % 42]++;

    Arrays.sort(remains);

    int theNumberOfRemains = 0;
    for (int i = 0; i < remains.length; i++) {
      if (remains[remains.length - 1 - i] == 0)
        break;

      theNumberOfRemains++;
    }

    System.out.print(theNumberOfRemains);
  }
}
