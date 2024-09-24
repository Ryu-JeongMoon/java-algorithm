package algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * Find First and Last Position of Element in Sorted Array
 */
public class _34_2 {

  public static void main(String[] args) {
    _34_2 instance = new _34_2();

    System.out.println(Arrays.toString(instance.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    System.out.println(Arrays.toString(instance.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
    System.out.println(Arrays.toString(instance.searchRange(new int[]{}, 0)));
    System.out.println(Arrays.toString(instance.searchRange(new int[]{1}, 1)));
    System.out.println(Arrays.toString(instance.searchRange(new int[]{2, 2}, 2)));
    System.out.println(Arrays.toString(instance.searchRange(new int[]{1, 3}, 1)));
  }

  public int[] searchRange(int[] nums, int target) {
    int[] result = new int[2];
    result[0] = findFirst(nums, target);
    result[1] = findLast(nums, target);
    return result;
  }

  private int findFirst(int[] nums, int target) {
    int first = -1, left = 0, right = nums.length;
    while (left < right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        first = mid;
        right = mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return first;
  }

  private int findLast(int[] nums, int target) {
    int first = -1, left = 0, right = nums.length;
    while (left < right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        first = mid;
        left = mid + 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return first;
  }
}

/*
time complexity
O(logN)

critical point
first, last 각각 O(logN)으로 찾기

reference
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
*/
