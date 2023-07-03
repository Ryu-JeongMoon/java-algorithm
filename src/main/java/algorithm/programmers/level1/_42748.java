package algorithm.programmers.level1;

import java.util.Arrays;

/**
 * K번째수
 */
public class _42748 {

  public static void main(String[] args) {
    _42748 instance = new _42748();
    System.out.println(Arrays.toString(instance.solution(
      new int[] { 1, 5, 2, 6, 3, 7, 4 },
      new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } })));
  }

  public int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];
    for (int i = 0; i < commands.length; i++) {
      int[] copy = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
      Arrays.sort(copy);
      answer[i] = copy[commands[i][2] - 1];
    }
    return answer;
  }
}

/*
time complexity
M = commands.length
N = copy.length
O(M * NlogN)

critical point

reference
https://programmers.co.kr/learn/courses/30/lessons/42748
 */
