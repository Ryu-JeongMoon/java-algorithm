package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 균형잡힌 세상
 */
public class _4949 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    String line;
    outer:
    while (!(line = br.readLine()).equals(".")) {
      stack.clear();

      for (int i = 0; i < line.length(); i++) {
        char current = line.charAt(i);
        if (current == '(' || current == '[') {
          stack.push(current);
        } else if (current == ')') {
          if (stack.isEmpty() || stack.pop() != '(') {
            sb.append("no\n");
            continue outer;
          }
        } else if (current == ']') {
          if (stack.isEmpty() || stack.pop() != '[') {
            sb.append("no\n");
            continue outer;
          }
        }
      }

      sb.append(stack.isEmpty() ? "yes\n" : "no\n");
    }

    br.close();
    System.out.print(sb);
  }
}

/*
time complexity
O(n)

critical point
종료 조건 주의 ...

reference
https://www.acmicpc.net/problem/4949
*/
