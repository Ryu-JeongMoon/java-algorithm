package algorithm.solvedac.bronze_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 대표값
 */
public class _2587 {

  public static void main(String[] args) throws IOException {
    int n = 5, sum = 0;
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = nextInt();
      sum += array[i];

      int currentIndex = i;
      while (currentIndex > 0 && array[currentIndex] < array[currentIndex - 1]) {
        int temp = array[currentIndex];
        array[currentIndex] = array[currentIndex - 1];
        array[currentIndex - 1] = temp;
        --currentIndex;
      }
    }
    System.out.println(sum / n);
    System.out.println(array[n / 2]);
  }
}

/*
time complexity
O(N^2)

critical point
insertion sort

reference
https://www.acmicpc.net/problem/2587
*/
