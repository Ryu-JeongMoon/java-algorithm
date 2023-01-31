package algorithm.forjava.chpa04;

import java.util.Stack;

/**
 * 문제 6, 7
 */
public class AdvancedStack extends Stack {

  private final Stack<Integer> elementStack = new Stack<>();
  private final Stack<Integer> minStack = new Stack<>();

  public void push(int data) {
    elementStack.push(data);
    if (minStack.isEmpty() || minStack.peek() >= data) {
      minStack.push(data);
    } else {
      minStack.push(minStack.peek());
    }
  }

  public Integer pop() {
    return elementStack.isEmpty() ? null : elementStack.pop();
  }

  public Integer advancedPop() {
    if (elementStack.isEmpty()) {
      return null;
    }

    Integer minTop = minStack.pop();
    Integer elementTop = elementStack.peek();

    if (minTop.intValue() == elementTop.intValue()) {
      minStack.pop();
    }
    return elementStack.pop();
  }

  public int getMinimum() {
    return minStack.pop();
  }

  public int top() {
    return elementStack.peek();
  }

  public boolean isEmpty() {
    return elementStack.isEmpty();
  }
}
