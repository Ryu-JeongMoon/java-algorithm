package algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * Find First and Last Position of Element in Sorted Array
 */
public class _34 {

  public static void main(String[] args) {
    _34 instance = new _34();

    System.out.println(Arrays.toString(instance.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    System.out.println(Arrays.toString(instance.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
    System.out.println(Arrays.toString(instance.searchRange(new int[]{}, 0)));
    System.out.println(Arrays.toString(instance.searchRange(new int[]{1}, 1)));
    System.out.println(Arrays.toString(instance.searchRange(new int[]{2, 2}, 2)));
    System.out.println(Arrays.toString(instance.searchRange(new int[]{1, 3}, 1)));
  }

  public int[] searchRange(int[] nums, int target) {
    int length = nums.length, left = 0, right = length, start = -1, end = -1;
    while (left < right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        for (int i = mid; i >= 0; i--) {
          if (nums[i] == target) {
            start = i;
          } else {
            break;
          }
        }

        for (int i = mid; i < length; i++) {
          if (nums[i] == target) {
            end = i;
          } else {
            break;
          }
        }

        break;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return new int[]{start, end};
  }
}

/*
time complexity
O(N)

critical point
target 같은 값 찾은 후 (선형 검색)x2

reference
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
*/
