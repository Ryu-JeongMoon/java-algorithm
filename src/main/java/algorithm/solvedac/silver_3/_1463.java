package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 1로 만들기
 */
public class _1463 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    System.out.println(findIteratively(n));
    System.out.println(findRecursively(n, 0));
  }

  private static int findIteratively(int n) {
    int[] numbers = new int[n + 1];
    for (int i = 2; i < numbers.length; i++) {
      numbers[i] = numbers[i - 1] + 1;
      if (i % 2 == 0) {
        numbers[i] = Math.min(numbers[i], numbers[i / 2] + 1);
      }
      if (i % 3 == 0) {
        numbers[i] = Math.min(numbers[i], numbers[i / 3] + 1);
      }
    }
    return numbers[n];
  }

  private static int findRecursively(int n, int count) {
    return n < 2
      ? count
      : Math.min(findRecursively(n / 2, count + 1 + (n % 2)), findRecursively(n / 3, count + 1 + (n % 3)));
  }
}

/*
time complexity
findIteratively - O(n)
findRecursively - O(n)

critical point
재귀적 접근은 각 스텝마다 n/2, n/3이므로 더 빠름

reference
https://www.acmicpc.net/problem/1463
*/
