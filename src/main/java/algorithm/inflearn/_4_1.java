package algorithm.inflearn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 이진수 정렬
 */
public class _4_1 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution1(new int[]{ 5, 6, 7, 8, 9 })));
    System.out.println(Arrays.toString(solution1(new int[]{ 5, 4, 3, 2, 1 })));
    System.out.println(Arrays.toString(solution1(new int[]{ 12, 5, 7, 23, 45, 21, 17 })));

    System.out.println(Arrays.toString(solution2(new int[]{ 5, 6, 7, 8, 9 })));
    System.out.println(Arrays.toString(solution2(new int[]{ 5, 4, 3, 2, 1 })));
    System.out.println(Arrays.toString(solution2(new int[]{ 12, 5, 7, 23, 45, 21, 17 })));
  }

  public static Integer[] solution1(int[] nums) {
    Integer[] boxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);
    Arrays.sort(boxed, Comparator.comparing(Integer::toBinaryString, (s1, s2) -> {
      int s1Count = 0, s2Count = 0;
      for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) == '1') {
          ++s1Count;
        }
      }
      for (int i = 0; i < s2.length(); i++) {
        if (s2.charAt(i) == '1') {
          ++s2Count;
        }
      }

      return s1Count == s2Count ? Integer.parseInt(s1) - Integer.parseInt(s2) : s1Count - s2Count;
    }));
    return boxed;
  }

  public static int[] solution2(int[] nums) {
    int[][] pair = new int[nums.length][2];
    for (int i = 0; i < nums.length; i++) {
      pair[i][0] = nums[i];
      int temp = nums[i];
      while (temp > 0) {
        pair[i][1] += (temp & 1);
        temp /= 2;
      }
    }
    Arrays.sort(pair, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

    int[] answer = new int[nums.length];
    for (int i = 0; i < pair.length; i++) {
      answer[i] = pair[i][0];
    }
    return answer;
  }
}

/*
time complexity
O(NlogN)

critical point

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=149929
 */