package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.Arrays;

/**
 * 물 주기
 */
public class _23351 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), k = nextInt(), a = nextInt(), b = nextInt(), index = 0, day = 0;
    int[] array = new int[n];
    Arrays.fill(array, k);
    boolean withered = false;
    while (!withered) {
      for (int i = index; i < index + a; i++) {
        array[i] += b - 1;
      }

      for (int i = 0; i < array.length; i++) {
        if (i < index || i >= index + a) {
          if (array[i] == 1) {
            withered = true;
            break;
          } else {
            --array[i];
          }
        }
      }

      index = (index + a) % n;
      ++day;
    }
    System.out.println(day);
  }
}

/*
time complexity
O(N)

critical point

reference
https://www.acmicpc.net/problem/23351
*/
