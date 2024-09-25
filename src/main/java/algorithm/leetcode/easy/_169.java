package algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Majority Element
 */
public class _169 {

  public static void main(String[] args) {
    _169 instance = new _169();

    System.out.println(instance.majorityElement(new int[]{3, 2, 3}));
    System.out.println(instance.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
  }

  public int majorityElement(int[] nums) {
    Map<Integer, Integer> frequency = new HashMap<>();
    int max = 0, maxFrequency = 0;
    for (int num : nums) {
      int value = frequency.getOrDefault(num, 0) + 1;
      if (value > maxFrequency) {
        max = num;
        maxFrequency = value;
      }
      frequency.put(num, value);
    }
    return max;
  }
}

/*
time complexity
O(N)

critical point

reference
https://leetcode.com/problems/majority-element/
*/
