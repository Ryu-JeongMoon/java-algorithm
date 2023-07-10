package algorithm.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _72411_2 {

  private Map<String, Integer> courseFrequency;

  public static void main(String[] args) {
    _72411_2 instance = new _72411_2();
    System.out.println(Arrays.toString(instance.solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" }, new int[] { 2, 3, 4 })));
    System.out.println(Arrays.toString(instance.solution(new String[] { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" }, new int[] { 2, 3, 5 })));
    System.out.println(Arrays.toString(instance.solution(new String[] { "XYZ", "XWY", "WXA" }, new int[] { 2, 3, 4 })));
  }

  public String[] solution(String[] orders, int[] courses) {
    courseFrequency = new HashMap<>();

    for (String order : orders) {
      char[] orderChars = order.toCharArray();
      Arrays.sort(orderChars);
      for (int numberOfCourse : courses) {
        if (numberOfCourse <= orderChars.length) {
          generateCombinations(orderChars, numberOfCourse, 0, new StringBuilder());
        }
      }
    }
    return getValidCourses();
  }

  private void generateCombinations(char[] orderChars, int numberOfCourse, int index, StringBuilder sb) {
    if (sb.length() == numberOfCourse) {
      String key = sb.toString();
      courseFrequency.put(key, courseFrequency.getOrDefault(key, 0) + 1);
      return;
    }

    for (int i = index; i < orderChars.length; i++) {
      sb.append(orderChars[i]);
      generateCombinations(orderChars, numberOfCourse, i + 1, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  private String[] getValidCourses() {
    List<String> validCourses = new ArrayList<>();
    Map<Integer, Integer> maxFrequenciesPerCourse = new HashMap<>();
    for (Map.Entry<String, Integer> entry : courseFrequency.entrySet()) {
      String course = entry.getKey();
      int frequency = entry.getValue();
      int courseLength = course.length();

      int maxFrequency = maxFrequenciesPerCourse.getOrDefault(courseLength, 0);
      if (frequency > maxFrequency) {
        maxFrequenciesPerCourse.put(courseLength, frequency);
        validCourses.removeIf(c -> c.length() == courseLength);
      }

      if (frequency > 1 && frequency >= maxFrequency) {
        validCourses.add(course);
      }
    }

    validCourses.sort(String::compareTo);
    return validCourses.toArray(new String[0]);
  }
}

/*
time complexity
주문 빈도 최댓값 구하는 로직 차이 (stream vs for-each)

72411_1                                72411_2
테스트 1  〉	통과 (8.19ms, 77MB)      테스트 1  〉	통과 (2.32ms, 76.2MB)
테스트 2  〉	통과 (10.59ms, 73.1MB)   테스트 2  〉	통과 (2.02ms, 82.8MB)
테스트 3  〉	통과 (16.00ms, 68.5MB)   테스트 3  〉	통과 (3.24ms, 77.4MB)
테스트 4  〉	통과 (10.92ms, 80.7MB)   테스트 4  〉	통과 (2.18ms, 71.1MB)
테스트 5  〉	통과 (14.17ms, 84.2MB)   테스트 5  〉	통과 (2.00ms, 76.2MB)
테스트 6  〉	통과 (10.21ms, 77.5MB)   테스트 6  〉	통과 (3.03ms, 77.8MB)
테스트 7  〉	통과 (12.81ms, 77.3MB)   테스트 7  〉	통과 (2.67ms, 73.8MB)
테스트 8  〉	통과 (21.72ms, 88.4MB)   테스트 8  〉	통과 (4.72ms, 81.9MB)
테스트 9  〉	통과 (18.92ms, 88.3MB)   테스트 9  〉	통과 (5.58ms, 80.5MB)
테스트 10 〉	통과 (21.46ms, 88.3MB)   테스트 10 〉	통과 (6.72ms, 84.5MB)
테스트 11 〉	통과 (15.98ms, 87.1MB)   테스트 11 〉	통과 (3.73ms, 77.4MB)
테스트 12 〉	통과 (13.02ms, 82.1MB)   테스트 12 〉	통과 (4.15ms, 80.6MB)
테스트 13 〉	통과 (17.57ms, 79.5MB)   테스트 13 〉	통과 (7.34ms, 78MB)
테스트 14 〉	통과 (13.14ms, 78MB)     테스트 14 〉	통과 (7.37ms, 87.9MB)
테스트 15 〉	통과 (13.61ms, 83.7MB)   테스트 15 〉	통과 (5.55ms, 82.3MB)
테스트 16 〉	통과 (11.80ms, 77.1MB)   테스트 16 〉	통과 (4.56ms, 79.6MB)
테스트 17 〉	통과 (12.35ms, 81.7MB)   테스트 17 〉	통과 (5.95ms, 94.9MB)
테스트 18 〉	통과 (10.60ms, 75.2MB)   테스트 18 〉	통과 (4.36ms, 80.2MB)
테스트 19 〉	통과 (13.44ms, 87.4MB)   테스트 19 〉	통과 (3.50ms, 85.7MB)
테스트 20 〉	통과 (16.50ms, 90.4MB)   테스트 20 〉	통과 (4.25ms, 78.6MB)
*/
