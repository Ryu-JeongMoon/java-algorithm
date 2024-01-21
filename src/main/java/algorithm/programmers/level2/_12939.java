package algorithm.programmers.level2;

import java.util.Arrays;

/**
 * 최댓값과 최솟값
 */
public class _12939 {

  public static void main(String[] args) {
    _12939 instance = new _12939();
    System.out.println(instance.solution("1 2 3 4"));
    System.out.println(instance.solution("-1 -2 -3 -4"));
    System.out.println(instance.solution("-1 -1"));
  }

  private String solution(String s) {
    String[] values = s.split(" ");
    int[] numbers = new int[values.length];
    for (int i = 0; i < values.length; i++) {
      numbers[i] = Integer.parseInt(values[i]);
    }
    Arrays.sort(numbers);
    return String.format("%d %d", numbers[0], numbers[numbers.length - 1]);
  }
}

/*
time complexity
O(N)

critical point

reference
https://programmers.co.kr/learn/courses/30/lessons/12939
*/
