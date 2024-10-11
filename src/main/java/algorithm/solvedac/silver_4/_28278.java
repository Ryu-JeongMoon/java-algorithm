package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 스택 2
 */
public class _28278 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    IntStack stack = new IntStack(n);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int action = nextInt();
      if (action == 1) {
        int value = nextInt();
        stack.push(value);
        continue;
      }

      if (action == 2) {
        sb.append(stack.pop());
      } else if (action == 3) {
        sb.append(stack.size());
      } else if (action == 4) {
        sb.append(stack.isEmpty());
      } else if (action == 5) {
        sb.append(stack.peek());
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }

  private static class IntStack {

    private int index;
    private final int[] array;

    private IntStack(int size) {
      index = 0;
      array = new int[size];
    }

    private void push(int value) {
      array[index++] = value;
    }

    private int pop() {
      return index == 0 ? -1 : array[--index];
    }

    private int size() {
      return index;
    }

    private int isEmpty() {
      return size() == 0 ? 1 : 0;
    }

    private int peek() {
      return index != 0 ? array[index - 1] : -1;
    }
  }
}

/*
time complexity
O(N)

critical point

reference
https://www.acmicpc.net/problem/28278
*/
