package algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * 3Sum Closest
 */
public class _16_2 {

  public static void main(String[] args) {
    _16_2 instance = new _16_2();

    System.out.println(instance.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
    System.out.println(instance.threeSumClosest(new int[] { 0, 0, 0 }, 1));
  }

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);

    int closestSum = 2 << 24, length = nums.length;
    for (int i = 0; i < length - 2; i++) {
      int j = i + 1, k = length - 1;
      while (j < k) {
        int nextSum = nums[i] + nums[j] + nums[k];
        if (nextSum == target) {
          return nextSum;
        } else if (nextSum < target) {
          ++j;
        } else {
          --k;
        }

        if (Math.abs(nextSum - target) < Math.abs(closestSum - target)) {
          closestSum = nextSum;
        }
      }
    }

    return closestSum;
  }
}

/*
time complexity
O(N^2)

critical point
3-pointer

reference
https://leetcode.com/problems/3sum-closest/
*/
