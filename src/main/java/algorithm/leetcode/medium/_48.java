package algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * Rotate Image
 */
public class _48 {

  public static void main(String[] args) {
    _48 instance = new _48();

    int[][] matrix = {
      { 1, 2, 3 },
      { 4, 5, 6 },
      { 7, 8, 9 }
    };
    instance.rotate(matrix);
    System.out.println(Arrays.deepToString(matrix));

    matrix = new int[][] {
      { 5, 1, 9, 11 },
      { 2, 4, 8, 10 },
      { 13, 3, 6, 7 },
      { 15, 14, 12, 16 }
    };
    instance.rotate(matrix);
    System.out.println(Arrays.deepToString(matrix));
  }

  public void rotate(int[][] matrix) {
    int length = matrix.length;
    int[][] copy = new int[length][length];
    for (int i = 0; i < length; i++) {
      System.arraycopy(matrix[i], 0, copy[i], 0, length);
    }

    for (int i = 0; i < length; i++) {
      int[] src = copy[i];
      int targetCol = length - i - 1;
      for (int j = 0; j < length; j++) {
        matrix[j][targetCol] = src[j];
      }
    }
  }
}

/*
time complexity
O(n^2)

critical point
90' 회전 == 행을 열로

reference
https://leetcode.com/problems/rotate-image/
*/
