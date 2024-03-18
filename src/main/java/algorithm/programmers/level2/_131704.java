package algorithm.programmers.level2;

import java.util.Stack;

/**
 * 택배상자
 */
public class _131704 {

  public static void main(String[] args) {
    _131704 instance = new _131704();
    System.out.println(instance.solution(new int[] { 4, 3, 1, 2, 5 }));
    System.out.println(instance.solution(new int[] { 5, 4, 3, 2, 1 }));
  }

  public int solution(int[] order) {
    Stack<Integer> stack = new Stack<>();
    int index = 0;
    for (int i = 0; i < order.length; i++) {
      stack.push(i + 1);
      while (!stack.isEmpty() && stack.peek() == order[index]) {
        stack.pop();
        index++;
      }
    }
    return index;
  }
}

/*
time complexity
O(N)

critical point
복잡하게 생각하지 말고 일단 넣어서 비교하면 간편!

reference
https://school.programmers.co.kr/learn/courses/30/lessons/131704
*/
