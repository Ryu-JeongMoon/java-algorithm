package algorithm.leetcode.easy;

/**
 * 2367. Number of Arithmetic Triplets
 */
public class _2367 {

  public static void main(String[] args) {
    System.out.println(arithmeticTriplets(new int[] { 0, 1, 4, 6, 7, 10 }, 3));
    System.out.println(arithmeticTriplets(new int[] { 4, 5, 6, 7, 8, 9 }, 2));
  }

  public static int arithmeticTriplets(int[] nums, int diff) {
    boolean[] values = new boolean[201];
    for (int num : nums) {
      values[num] = true;
    }

    int count = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] + diff * 2 <= 200 && values[nums[i] + diff] && values[nums[i] + diff * 2]) {
        count++;
      }
    }

    return count;
  }
}

/*
nums = [4,5,6,7,8,9], diff = 2
Output: 2
Explanation:
(0, 2, 4) is an arithmetic triplet because both 8 - 6 == 2 and 6 - 4 == 2.
(1, 3, 5) is an arithmetic triplet because both 9 - 7 == 2 and 7 - 5 == 2.

0 <= nums[i] <= 200
1 <= diff <= 50

조건 누락.. 제약 조건 잘 읽기
nums[i] + diff * 2 <= 200
 */
