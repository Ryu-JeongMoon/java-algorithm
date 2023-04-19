package algorithm.inflearn;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 최대 길이 연속수열
 */
public class _3_1 {

  public static void main(String[] args) {
    System.out.println(solution2(new int[] { 8, 1, 9, 3, 10, 2, 4, 0, 2, 3 }));
    System.out.println(solution2(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0 }));
    System.out.println(solution2(new int[] { 3, 3, 3, 3, 3, 3, 3, 3 }));
    System.out.println(solution2(new int[] { -3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1 }));
    System.out.println(solution2(new int[] { -5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7 }));
  }

  public static int solution(int[] nums) {
    Arrays.sort(nums);
    int temporary = 1, max = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        continue;
      }

      if (nums[i] + 1 == nums[i + 1]) {
        ++temporary;
      } else {
        max = Math.max(max, temporary);
        temporary = 1;
      }
    }

    return Math.max(max, temporary);
  }

  public static int solution2(int[] nums) {
    TreeSet<Integer> set = new TreeSet<>();
    for (int num : nums) {
      set.add(num);
    }

    int temporary = 1, max = 0;
    for (Integer value : set) {
      if (set.contains(value + 1)) {
        ++temporary;
      } else {
        max = Math.max(max, temporary);
        temporary = 1;
      }
    }

    return Math.max(max, temporary);
  }
}

/*
time complexity
O(NlogN)

critical point
마지막 값까지 연속해서 증가하는 값이라면 max 갱신하지 못함, 외부에서 갱신 필요

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=149914
 */
