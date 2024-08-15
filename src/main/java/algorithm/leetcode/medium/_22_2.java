package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses
 */
public class _22_2 {

  public static void main(String[] args) {
    _22_2 instance = new _22_2();

    System.out.println(instance.generateParenthesis(3));
    System.out.println(instance.generateParenthesis(1));
  }

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    visit(0, 0, n, new StringBuilder(), result);
    return result;
  }

  private void visit(int open, int close, int n, StringBuilder sb, List<String> result) {
    if (sb.length() == n * 2) {
      result.add(sb.toString());
      return;
    }

    if (open < n) {
      visit(open + 1, close, n, sb.append('('), result);
      sb.deleteCharAt(sb.length() - 1);
    }

    if (open > close) {
      visit(open, close + 1, n, sb.append(')'), result);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}

/*
time complexity
O(2^N)

critical point
0 ms, Beats 100.00%

reference
https://leetcode.com/problems/generate-parentheses/
 */
