package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum
 */
public class _15_2 {

  public static void main(String[] args) {
    _15_2 instance = new _15_2();

    System.out.println(instance.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    System.out.println(instance.threeSum(new int[] { 0, 1, 1 }));
    System.out.println(instance.threeSum(new int[] { 0, 0, 0 }));
    System.out.println(instance.threeSum(new int[] { 0, 0, 0, 0 }));
    System.out.println(instance.threeSum(new int[] { 3, 0, -2, -1, 1, 2 }));
  }

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    int length = nums.length;
    for (int i = 0; i < length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      int mid = i + 1, right = length - 1;
      while (mid < right) {
        int l = nums[i], m = nums[mid], r = nums[right];
        int sum = l + m + r;
        if (sum > 0) {
          --right;
        } else if (sum < 0) {
          ++mid;
        } else {
          result.add(List.of(l, m, r));
          while (++mid < right && nums[mid] == l) {
          }
          while (mid < --right && nums[right] == r) {
          }
        }
      }
    }

    return result;
  }
}

/*
time complexity
O(N^2)

critical point
27 ms, Beats 84.71%
1. 중복 제거를 위해 첫번째 수행이 아니며 left, mid 동일한 값인 경우 생략
2. 기준점을 가장 왼쪽으로 잡고(left) <-mid, right-> 이동

reference
https://leetcode.com/problems/3sum
*/
