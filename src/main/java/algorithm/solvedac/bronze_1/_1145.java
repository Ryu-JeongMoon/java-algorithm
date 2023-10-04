package algorithm.solvedac.bronze_1;

import static algorithm.util.MathUtils.gcd;
import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 적어도 대부분의 배수
 */
public class _1145 {

  public static void main(String[] args) throws IOException {
    int[] ints = new int[5];
    for (int i = 0; i < ints.length; i++) {
      ints[i] = nextInt();
    }

    int min = Integer.MAX_VALUE, temp;
    for (int i = 0; i < ints.length - 2; i++) {
      for (int j = i + 1; j < ints.length - 1; j++) {
        temp = ints[i] * ints[j] / gcd(Math.max(ints[j], ints[i]), Math.min(ints[j], ints[i]));
        for (int k = j + 1; k < ints.length; k++) {
          min = Math.min(min, temp * ints[k] / gcd(Math.max(temp, ints[k]), Math.min(temp, ints[k])));
        }
      }
    }
    System.out.println(min);
  }
}

/*
time complexity
O(n^3)
n=5 고정, O(1)

critical point
LCM 반복

reference
https://www.acmicpc.net/problem/1145
*/
