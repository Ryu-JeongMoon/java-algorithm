package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 */
public class _46 {

  public static void main(String[] args) {
    _46 instance = new _46();

    System.out.println(instance.permute(new int[] {1, 2, 3}));
    System.out.println(instance.permute(new int[] {0, 1}));
    System.out.println(instance.permute(new int[] {1}));
  }

  private static final List<List<Integer>> RESULT = new ArrayList<>();

  public List<List<Integer>> permute(int[] nums) {
    RESULT.clear();
    visit(nums, new boolean[nums.length], 0, nums.length, new ArrayList<>());
    return RESULT;
  }

  private void visit(int[] nums, boolean[] visited, int step, int length, List<Integer> numbers) {
    if (step == length) {
      RESULT.add(new ArrayList<>(numbers));
      return;
    }

    for (int i = 0; i < length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        numbers.add(nums[i]);
        visit(nums, visited, step + 1, length, numbers);
        numbers.removeLast();
        visited[i] = false;
      }
    }
  }
}

/*
time complexity
O(N!)

critical point

reference
https://leetcode.com/problems/permutations/
*/
