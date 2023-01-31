package algorithm.programmers.level1;

import java.util.Arrays;
import java.util.TreeSet;

public class PickTwoAndAdd {

  public static void main(String[] args) {
    int[] numbers = { 2, 1, 3, 4, 1 };
    System.out.println(Arrays.toString(solution(numbers)));
  }

  public static int[] solution(int[] numbers) {
    int[] answer = {};
    TreeSet<Integer> integers = new TreeSet<>();
    for (int i = 0; i < numbers.length; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        integers.add(numbers[i] + numbers[j]);
      }
    }

    return integers.stream().mapToInt(Integer::intValue).toArray();
  }
}

/*
TreeSet 쓰면 정렬도 됨!
 */
