package algorithm.leetcode.easy;

import java.util.Stack;

/**
 * Valid Parentheses
 */
public class _20 {

  public static void main(String[] args) {
    _20 instance = new _20();

    System.out.println(instance.isValid("()"));
    System.out.println(instance.isValid("()[]{}"));
    System.out.println(instance.isValid("(]"));
  }

  public boolean isValid(String s) {
    Stack<Character> parentheses = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      if (current == '(' || current == '{' || current == '[') {
        parentheses.push(current);
      } else if (current == ')' && (parentheses.empty() || parentheses.pop() != '(')) {
        return false;
      } else if (current == '}' && (parentheses.empty() || parentheses.pop() != '{')) {
        return false;
      } else if (current == ']' && (parentheses.empty() || parentheses.pop() != '[')) {
        return false;
      }
    }
    return parentheses.empty();
  }
}

/*
time complexity
O(N)

critical point

reference
https://leetcode.com/problems/valid-parentheses
*/
