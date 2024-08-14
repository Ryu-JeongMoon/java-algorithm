package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses
 */
public class _22 {

  public static void main(String[] args) {
    _22 instance = new _22();

    System.out.println(instance.generateParenthesis(3));
    System.out.println(instance.generateParenthesis(1));
  }

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    visit(0, n, new StringBuilder(), result);
    return result;
  }

  private void visit(int open, int n, StringBuilder sb, List<String> result) {
    if (open * 2 < sb.length() || sb.length() == 2 * n) {
      return;
    }

    if (open == n) {
      while (sb.length() != 2 * n) {
        sb.append(')');
      }
      result.add(sb.toString());
      return;
    }

    visit(open + 1, n, sb.append('('), result);

    while (sb.charAt(sb.length() - 1) == ')' && sb.length() > 1) {
      sb.deleteCharAt(sb.length() - 1);
    }
    visit(open, n, sb.deleteCharAt(sb.length() - 1).append(')'), result);
  }
}

/*
time complexity
O(2^N)

critical point
유효하지 않은 괄호 제외하기

reference
https://leetcode.com/problems/generate-parentheses/
*/
