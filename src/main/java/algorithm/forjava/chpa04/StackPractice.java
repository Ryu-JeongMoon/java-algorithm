package algorithm.forjava.chpa04;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackPractice {

  public static void main(String[] args) {
    String s = "{(abcd)asd()fadsf}";
    System.out.println(isPair(s));
  }

  public static boolean isPair(String str) {
    Stack<Character> tempStorage = new Stack<>();
    for (char c : str.toCharArray()) {
      if (c == '{') {
        tempStorage.push(c);
      }

      if (c == '}') {
        if (tempStorage.isEmpty()) {
          throw new EmptyStackException();
        }

        if (tempStorage.peek() != '{') {
          throw new IllegalArgumentException();
        }

        if (tempStorage.peek() == '{') {
          tempStorage.pop();
        }
      }

      if (c == '(') {
        tempStorage.push(c);
      }

      if (c == ')') {
        if (tempStorage.isEmpty()) {
          throw new EmptyStackException();
        }

        if (tempStorage.peek() != '(') {
          throw new IllegalArgumentException();
        }

        if (tempStorage.peek() == '(') {
          tempStorage.pop();
        }
      }
    }
    return true;
  }
}
