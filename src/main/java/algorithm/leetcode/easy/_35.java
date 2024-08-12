package algorithm.leetcode.easy;

/**
 * Search Insert Position
 */
public class _35 {

  public static void main(String[] args) {
    _35 instance = new _35();

    System.out.println(instance.searchInsert(new int[] { 1, 3, 5, 6 }, 5));
    System.out.println(instance.searchInsert(new int[] { 1, 3, 5, 6 }, 2));
    System.out.println(instance.searchInsert(new int[] { 1, 3, 5, 6 }, 7));
    System.out.println(instance.searchInsert(new int[] { 1, 3, 5, 6 }, 0));
  }

  public int searchInsert(int[] nums, int target) {
    int left = 0, right = nums.length, index = 0;
    while (left < right) {
      int mid = (right + left) / 2;
      int initialValue = nums[mid];
      if (initialValue > target) {
        index = right = mid;
      } else if (initialValue < target) {
        index = left = mid + 1;
      } else {
        return mid;
      }
    }
    return index;
  }
}

/*
time complexity
O(logN)

critical point
target이 존재하지 않을 때, 삽입할 위치를 찾는 문제

reference
https://leetcode.com/problems/search-insert-position
*/
