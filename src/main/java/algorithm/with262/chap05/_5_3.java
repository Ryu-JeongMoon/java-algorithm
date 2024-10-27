package algorithm.with262.chap05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 임의의 두 정수값 곱하기
 */
public class _5_3 {

  public static void main(String[] args) {
    System.out.println(multiply(new int[]{1, 2, 3}, new int[]{9, 8, 7}));
    System.out.println(multiply(new int[]{1, 9, 3, 7, 0, 7, 7, 2, 1}, new int[]{-7, 6, 1, 8, 3, 8, 2, 5, 7, 2, 8, 7}));
  }

  private static List<Integer> multiply(int[] a, int[] b) {
    int sign = a[0] * b[0] > 0 ? 1 : -1;
    if (a[0] < 0) {
      a[0] = -a[0];
    }
    if (b[0] < 0) {
      b[0] = -b[0];
    }

    List<Integer> carriers = new ArrayList<>(Collections.nCopies(a.length + b.length, 0));
    int lengthOfA = a.length, lengthOfB = b.length;
    for (int i = lengthOfB - 1; i >= 0; i--) {
      int standard = b[i];

      for (int j = lengthOfA - 1; j >= 0; j--) {
        int multiplied = standard * a[j];
        int carried = multiplied / 10;
        int current = multiplied % 10;

        int currentIndex = lengthOfA + lengthOfB - (i + j + 2);
        int currentSum = current + carriers.get(currentIndex);
        int nextIndex = currentIndex + 1;
        if (currentSum >= 10) {
          carried += currentSum / 10;
          currentSum %= 10;
        }
        carriers.set(currentIndex, currentSum);

        if (carried != 0) {
          if (carriers.get(nextIndex) != null) {
            carriers.set(nextIndex, carriers.get(nextIndex) + carried);
          } else {
            carriers.set(nextIndex, carried);
          }
        }
      }
    }

    List<Integer> reversed = carriers.reversed();
    int zeroIndex = 0;
    for (int i = 0; i < reversed.size(); i++) {
      if (reversed.get(i) != 0) {
        zeroIndex = i;
        break;
      }
    }

    if (reversed.isEmpty()) {
      return List.of(0);
    }

    List<Integer> result = reversed.subList(zeroIndex, reversed.size());
    result.set(0, result.getFirst() * sign);
    return result;
  }
}

/*
time complexity
O(NM)

critical point
범위를 벗어나는 값의 연산
1. Array
2. BigDecimal

reference
5.3 임의의 두 정수값 곱하기
*/
