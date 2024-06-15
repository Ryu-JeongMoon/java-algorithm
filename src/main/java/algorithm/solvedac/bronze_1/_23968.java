package algorithm.solvedac.bronze_1;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 알고리즘 수업 - 버블 정렬 1
 */
public class _23968 {

  private static int count = 0, source = 0, target = 0;

  public static void main(String[] args) throws IOException {
    int n = nextInt(), k = nextInt();
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = nextInt();
    }

    bubbleSort(n, array, k);
    System.out.println(source == 0 ? -1 : source + " " + target);
  }

  private static void bubbleSort(int n, int[] array, int k) {
    for (int i = n - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (array[j] > array[j + 1]) {
          ++count;
          if (count == k) {
            source = array[j + 1];
            target = array[j];
            break;
          }

          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }
}

/*
time complexity
O(N^2)

critical point
understanding of bubble sort

reference
https://www.acmicpc.net/problem/23968
*/
