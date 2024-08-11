package algorithm.leetcode.easy;

/**
 * Remove Element
 */
public class _27 {

  public static void main(String[] args) {
    _27 instance = new _27();

    System.out.println(instance.removeElement(new int[] { 3, 2, 2, 3 }, 3));
    System.out.println(instance.removeElement(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2));
  }

  public int removeElement(int[] nums, int val) {
    int newLength = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[newLength] = nums[i];
        newLength++;
      }
    }
    return newLength;
  }
}

/*
time complexity
O(N)

critical point
val 동일한 값이 제거된 후의 길이는 신경쓰지 않으므로
새로운 배열을 만들지 않고 기존 배열을 수정

reference
https://leetcode.com/problems/remove-element/
*/
