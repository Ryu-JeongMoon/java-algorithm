package algorithm.programmers.level2;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 의상
 */
public class _42578 {

  public static void main(String[] args) {
    _42578 instance = new _42578();
    System.out.println(instance.solution(new String[][] { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" }, { "green_turban", "headgear" } }));
    System.out.println(instance.solution(new String[][] { { "crow_mask", "face" }, { "blue_sunglasses", "face" }, { "smoky_makeup", "face" } }));
  }

  public int solution(String[][] clothes) {
    return Arrays.stream(clothes)
      .collect(groupingBy(clothe -> clothe[1], HashMap::new, counting()))
      .values().stream()
      .mapToInt(i -> Math.toIntExact(i + 1))
      .reduce(1, (a, b) -> a * b) - 1;
  }
}

/*
time complexity
O(N)

critical point
groupingBy의 이해

reference
https://school.programmers.co.kr/learn/courses/30/lessons/42578
*/
