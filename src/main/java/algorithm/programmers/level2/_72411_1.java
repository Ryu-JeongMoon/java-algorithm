package algorithm.programmers.level2;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 메뉴 리뉴얼
 */
public class _72411_1 {

  private Map<String, Integer> courseFrequency;

  public static void main(String[] args) {
    _72411_1 instance = new _72411_1();
    System.out.println(Arrays.toString(instance.solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" }, new int[] { 2, 3, 4 })));
    System.out.println(Arrays.toString(instance.solution(new String[] { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" }, new int[] { 2, 3, 5 })));
    System.out.println(Arrays.toString(instance.solution(new String[] { "XYZ", "XWY", "WXA" }, new int[] { 2, 3, 4 })));
  }

  public String[] solution(String[] orders, int[] course) {
    courseFrequency = new HashMap<>();
    for (int numberOfCourse : course) {
      for (String order : orders) {
        char[] orderChars = order.toCharArray();
        Arrays.sort(orderChars);
        if (order.length() >= numberOfCourse) {
          appendToCourse(orderChars, new StringBuilder(), numberOfCourse, 0);
        }
      }
    }

    Map<Integer, Optional<Integer>> maxFrequenciesPerCourse = courseFrequency.entrySet().stream()
      .collect(groupingBy(entry -> entry.getKey().length(), mapping(Map.Entry::getValue, maxBy(Integer::compareTo))));

    return courseFrequency.entrySet().stream()
      .filter(entry -> {
        int maxValue = maxFrequenciesPerCourse.get(entry.getKey().length()).orElse(0);
        return maxValue > 1 ? maxValue == entry.getValue() : entry.getValue() > 1;
      })
      .map(Map.Entry::getKey)
      .sorted()
      .toArray(String[]::new);
  }

  private void appendToCourse(char[] orderChars, StringBuilder sb, int numberOfCourse, int index) {
    if (sb.length() == numberOfCourse) {
      String key = sb.toString();
      courseFrequency.put(key, courseFrequency.getOrDefault(key, 0) + 1);
      return;
    }

    for (int i = index; i < orderChars.length; i++) {
      sb.append(orderChars[i]);
      appendToCourse(orderChars, sb, numberOfCourse, i + 1);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}

/*
time complexity
m = course.length
n = orders.length
O(m * n * 2^n)

critical point
1. 코스 요리 개수마다 & 주문 메뉴 조합마다 순회 필요
2. 순회하는 동안 코스 요리 개수만큼 메뉴 조합 생성
3. 코스 요리 개수마다 주문 빈도 최댓값 저장
4. 가장 많은 빈도로 주문된 메뉴 조합 선택

reference
https://programmers.co.kr/learn/courses/30/lessons/72411
*/
