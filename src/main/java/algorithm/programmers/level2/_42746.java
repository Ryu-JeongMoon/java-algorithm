package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 가장 큰 수
 */
public class _42746 {

  public static void main(String[] args) {
    _42746 instance = new _42746();
    System.out.println(instance.solution(new int[] { 898, 89 }));
    System.out.println(instance.solution(new int[] { 818, 81 }));
    System.out.println(instance.solution(new int[] { 12, 1213 }));
    System.out.println(instance.solution(new int[] { 1000, 999 }));
    System.out.println(instance.solution(new int[] { 6, 10, 2 }));
    System.out.println(instance.solution(new int[] { 54, 549 }));
    System.out.println(instance.solution(new int[] { 0, 0, 0, 0 }));
    System.out.println(instance.solution(new int[] { 3, 30, 34, 5, 9 }));
  }

  public String solution(int[] numbers) {
    return Arrays.stream(numbers)
      .mapToObj(String::valueOf)
      .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
      .collect(Collectors.joining())
      .replaceAll("^0+", "0");
  }
}

/*
time complexity
O(NlogN)

critical point
성능 저하는 있으나 문자열 덧셈 비교를 통해 정렬하면 간편

reference
https://programmers.co.kr/learn/courses/30/lessons/42746
*/
