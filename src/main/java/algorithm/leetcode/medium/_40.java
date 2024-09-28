package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum II
 */
public class _40 {

  public static void main(String[] args) {
    _40 instance = new _40();

    System.out.println(instance.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    System.out.println(instance.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    System.out.println(instance.combinationSum2(new int[]{3, 1, 3, 5, 1, 1}, 8));
    System.out.println(instance.combinationSum2(
      new int[]{14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9, 9, 12, 34, 16, 25, 32, 8, 7, 30, 12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16, 8, 24,
        12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12}, 27));
    System.out.println(instance.combinationSum2(
      new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 30));
    System.out.println(instance.combinationSum2(new int[]{4, 4, 2, 1, 4, 2, 2, 1, 3}, 6));
  }

  private static final List<List<Integer>> RESULT = new ArrayList<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    RESULT.clear();
    Arrays.sort(candidates);
    findCombination(candidates, 0, 0, target, new ArrayList<>());
    return new ArrayList<>(RESULT);
  }

  private void findCombination(int[] candidates, int index, int sum, int target, List<Integer> list) {
    if (sum == target && !RESULT.contains(list)) {
      RESULT.add(new ArrayList<>(list));
      return;
    } else if (sum > target) {
      return;
    }

    for (int i = index; i < candidates.length; i++) {
      if (i > index && candidates[i] == candidates[i - 1]) {
        continue;
      }

      list.add(candidates[i]);
      findCombination(candidates, i + 1, sum + candidates[i], target, list);
      list.removeLast();
    }
  }
}

/*
time complexity
O(2^N)

critical point
6 ms, Beats 7.05%

reference
https://leetcode.com/problems/combination-sum-ii/
*/
