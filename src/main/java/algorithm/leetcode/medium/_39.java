package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum
 */
public class _39 {

  public static void main(String[] args) {
    _39 instance = new _39();

    System.out.println(instance.combinationSum(new int[] { 2, 3, 6, 7 }, 7));
    System.out.println(instance.combinationSum(new int[] { 2, 3, 5 }, 8));
    System.out.println(instance.combinationSum(new int[] { 2 }, 1));
    System.out.println(instance.combinationSum(new int[] { 8, 7, 4, 3 }, 11));
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    visit(0, target, 0, candidates, new ArrayList<>(), result);
    return result;
  }

  private void visit(int index, int target, int sum, int[] candidates, List<Integer> numbers, List<List<Integer>> result) {
    if (sum == target) {
      result.add(new ArrayList<>(numbers));
      return;
    }

    for (int i = index; i < candidates.length; i++) {
      int candidate = candidates[i];
      if (sum + candidate > target) {
        continue;
      }

      numbers.add(candidate);
      visit(i, target, sum + candidate, candidates, numbers, result);
      numbers.removeLast();
    }
  }
}

/*
time complexity
O(2^n)

critical point
1 ms, Beats 99.93%
candidates 정렬되지 않은 경우도 존재

reference
https://leetcode.com/problems/combination-sum/
*/
