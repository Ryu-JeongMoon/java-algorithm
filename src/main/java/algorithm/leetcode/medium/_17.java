package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Letter Combinations of a Phone Number
 */
public class _17 {

  private static final String[] LETTERS = {
    "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
  };

  public static void main(String[] args) {
    _17 instance = new _17();

    System.out.println(instance.letterCombinations("23"));
    System.out.println(instance.letterCombinations(""));
    System.out.println(instance.letterCombinations("2"));
  }

  public List<String> letterCombinations(String digits) {
    int length = digits.length();
    if (length == 0) {
      return Collections.emptyList();
    }

    String[] candidates = new String[length];
    for (int i = 0; i < length; i++) {
      candidates[i] = (LETTERS[digits.charAt(i) - '2']);
    }

    List<String> combinations = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    visit(candidates, 0, sb, combinations);
    return combinations;
  }

  private void visit(String[] candidates, int index, StringBuilder sb, List<String> combinations) {
    int length = sb.length();
    if (length == candidates.length) {
      combinations.add(sb.toString());
      sb.delete(length - 1, length);
      return;
    }

    for (int i = 0; i < candidates[index].length(); i++) {
      sb.append(candidates[index].charAt(i));
      visit(candidates, index + 1, sb, combinations);
      sb.delete(length, length + 1);
    }
  }
}

/*
time complexity
O(4^N)

critical point
dfs

reference
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
*/
