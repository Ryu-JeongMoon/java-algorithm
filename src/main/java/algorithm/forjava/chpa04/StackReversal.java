package algorithm.forjava.chpa04;

import java.util.Stack;

/**
 * 문제 11
 */
public class StackReversal {

  public static void main(String[] args) {
    Stack<Integer> integers = new Stack<>();
    integers.push(1);
    integers.push(2);
    integers.push(3);

    reverseStack(integers);

    System.out.println("integers = " + integers);
  }

  public static void reverseStack(Stack<Integer> stack) {
    if (stack.isEmpty()) {
      return;
    }

    Integer temp = stack.pop();
    reverseStack(stack);
    insertAtBottom(stack, temp);
  }

  private static void insertAtBottom(Stack<Integer> stack, int data) {
    if (stack.isEmpty()) {
      stack.push(data);
      return;
    }

    Integer temp = stack.pop();
    insertAtBottom(stack, data);
    stack.push(temp);
  }
}

/*
재귀적
 */
