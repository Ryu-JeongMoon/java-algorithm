package algorithm.algorithmbyimages.chap04.bubble_sort;

import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
    int[] arr = { 4, 3, 6, 8, 7, 1, 9, 2 };
    System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

    bubbleSort(arr);
    System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
  }

  private static void bubbleSort(int[] arr) {

    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 1; j < arr.length - i; j++) {
        if (arr[j] < arr[j - 1]) {
          int temp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }
}
