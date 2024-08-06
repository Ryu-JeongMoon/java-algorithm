package algorithm.leetcode.medium;

/**
 * 3Sum Closest
 */
public class _16 {

  public static void main(String[] args) {
    _16 instance = new _16();

    System.out.println(instance.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
    System.out.println(instance.threeSumClosest(new int[] { 0, 0, 0 }, 1));
  }

  public int threeSumClosest(int[] nums, int target) {
    int currentSum = 2 << 24, nextSum, nextDiff, length = nums.length;
    for (int i = 0; i < length - 2; i++) {
      for (int j = i + 1; j < length - 1; j++) {
        for (int k = j + 1; k < length; k++) {
          nextSum = nums[i] + nums[j] + nums[k];
          nextDiff = Math.abs(nextSum - target);
          if (nextDiff < Math.abs(currentSum - target)) {
            currentSum = nextSum;
          }

          if (currentSum == target) {
            return currentSum;
          }
        }
      }
    }
    return currentSum;
  }
}

/*
time complexity
O(N^3)

critical point
brute force

reference
https://leetcode.com/problems/3sum-closest/
*/
