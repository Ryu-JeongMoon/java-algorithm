package algorithm.programmers.level2;

import java.util.Arrays;

/**
 * 행렬의 곱셈
 */
public class _12949 {

  public static void main(String[] args) {
    _12949 instance = new _12949();

    int[][] arr1 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
    int[][] arr2 = { { 3, 3 }, { 3, 3 } };
    System.out.println(Arrays.deepToString(instance.solution(arr1, arr2)));

    arr1 = new int[][]{ { 2, 3, 2 }, { 4, 2, 4 }, { 3, 1, 4 } };
    arr2 = new int[][]{ { 5, 4, 3 }, { 2, 4, 1 }, { 3, 1, 1 } };
    System.out.println(Arrays.deepToString(instance.solution(arr1, arr2)));
  }

  public int[][] solution(int[][] arr1, int[][] arr2) {
    int rowLength = arr1.length, colLength = arr2[0].length;
    int[][] answer = new int[rowLength][colLength];
    for (int k = 0; k < colLength; k++) {
      for (int i = 0; i < rowLength; i++) {
        for (int j = 0; j < arr1[0].length; j++) {
          answer[i][k] += (arr1[i][j] * arr2[j][k]);
        }
      }
    }
    return answer;
  }
}

/*
time complexity
O(arr1.length * arr2[0].length * arr1[0].length)

critical point
행렬의 곱셈이 어떻게 수행되는지 그려보면 쉬움

reference
https://programmers.co.kr/learn/courses/30/lessons/12949
*/
