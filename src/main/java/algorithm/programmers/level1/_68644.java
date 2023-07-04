package algorithm.programmers.level1;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * 두 개 뽑아서 더하기
 */
public class _68644 {

  public static void main(String[] args) {
    _68644 instance = new _68644();
    System.out.println(Arrays.toString(instance.solution(new int[] { 2, 1, 3, 4, 1 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 5, 0, 2, 7 })));
  }

  public int[] solution(int[] numbers) {
    Set<Integer> values = new TreeSet<>();
    for (int i = 0; i < numbers.length - 1; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        values.add(numbers[i] + numbers[j]);
      }
    }

    return values.stream()
      .mapToInt(Integer::intValue)
      .toArray();
  }
}

/*
time complexity

critical point

reference
https://programmers.co.kr/learn/courses/30/lessons/68644
*/
