package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * 괄호
 */
public class _9012 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    Stack<Character> stack = new Stack<>();
    while (--n >= 0) {
      char[] chars = br.readLine().toCharArray();
      for (char c : chars) {
        if (stack.isEmpty()) {
          stack.push(c);
          if (c == ')') {
            break;
          }
        } else if (stack.peek() == '(' && c == ')') {
          stack.pop();
        } else {
          stack.push(c);
        }
      }
      bw.write(stack.isEmpty() ? "YES\n" : "NO\n");
      stack.clear();
    }
    bw.flush();
    bw.close();
  }
}

/*
time complexity
O(N)

critical point
스택을 이용한 괄호 검사

reference
https://www.acmicpc.net/problem/9012
*/
