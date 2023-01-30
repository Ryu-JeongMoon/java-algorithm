package implementation;

import java.util.Arrays;

/**
 * 삽입 정렬
 */
public class InsertionSort {

  public static void main(String[] args) {
    int[] array = { 45, 12, 85, 32, 89, 39, 69, 44, 42, 1, 6, 8 };
    int temp;

    for (int i = 1; i < array.length; i++) {
      for (int j = i; j > 0; j--) {
        if (array[j] < array[j - 1]) {
          temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
        }
      }
    }

    Arrays.stream(array)
      .forEach(System.out::println);
  }
}

/*
outer for-loop index 늘려가면서 inner for-loop 으로 이미 정렬된 부분들과 비교하여 제자리 찾아가게 만들기

Best Case, 이미 정렬된 상황에서는 outer for-loop 돌면서 한번씩만 비교하면 되므로 O(n)
Worst Case, 역순 정렬된 상황에서는 outer & inner for-loop 돌면서 모든 요소 움직여야 하므로 O(n^2)
 */