package algorithm.with262.chap05;

import java.util.Arrays;

/**
 * 네덜란드 국기 문제
 */
public class _5_1 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(swap(new int[] { 2, 0, 2, 1, 1, 0 }, 1)));
    System.out.println(Arrays.toString(swap(new int[] { 5, 8, 3, 6, 1, 1 }, 3)));
  }

  public static int[] swap(int[] input, int pivot) {
    int[] result = new int[input.length];
    int front = 0, back = input.length - 1;
    for (int i : input) {
      if (i < pivot) {
        result[front++] = i;
      } else if (i > pivot) {
        result[back--] = i;
      }
    }

    for (int i = 0; i < back - front + 1; i++) {
      result[front + i] = pivot;
    }
    return result;
  }
}

/*
time complexity
O(n)

critical point
two pointer, no sort
pivot 후처리

reference
5.1 네덜란드 국기 문제
*/
