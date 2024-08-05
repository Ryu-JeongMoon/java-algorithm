package algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * Remove Duplicates from Sorted Array
 */
public class _26 {

  public static void main(String[] args) {
    _26 instance = new _26();

    System.out.println(instance.removeDuplicates(new int[] { 1, 1, 2 }));
    System.out.println(instance.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
  }

  public int removeDuplicates(int[] nums) {
    int previous = Integer.MIN_VALUE, uniqueCount = 0;
    for (int current : nums) {
      if (previous != current) {
        previous = current;
        nums[uniqueCount++] = current;
      }
    }
    Arrays.fill(nums, uniqueCount, nums.length, '_');
    return uniqueCount;
  }
}

/*
time complexity
O(N)

critical point
array 갈아끼기

reference
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
*/
