package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 3Sum
 */
public class _15 {

  public static void main(String[] args) {
    _15 instance = new _15();

    System.out.println(instance.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    System.out.println(instance.threeSum(new int[] { 0, 1, 1 }));
    System.out.println(instance.threeSum(new int[] { 0, 0, 0 }));
    System.out.println(instance.threeSum(new int[] { 0, 0, 0, 0 }));
    System.out.println(instance.threeSum(new int[] { 3, 0, -2, -1, 1, 2 }));
  }

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    Set<List<Integer>> result = new HashSet<>();
    int length = nums.length;
    for (int i = 1; i < length - 1; i++) {
      int left = i - 1, right = i + 1;

      while (0 <= left && left < i && i < right && right < length) {
        int sum = nums[left] + nums[i] + nums[right];
        if (sum > 0) {
          --left;
        } else if (sum < 0) {
          ++right;
        } else {
          result.add(List.of(nums[left], nums[i], nums[right]));
          --left;
          ++right;
        }
      }
    }

    return new ArrayList<>(result);
  }
}

/*
time complexity
O(N^2)

critical point
578 ms, Beats 21.83%
1. 중복 제거를 위해 Set 사용
2. 기준점을 가운데로 잡고(mid) <-left, right-> 이동

reference
https://leetcode.com/problems/3sum
*/
