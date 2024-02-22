package algorithm.programmers.level1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 카드 뭉치
 */
public class _159994 {

  public static void main(String[] args) {
    _159994 instance = new _159994();
    System.out.println(instance.solution(
      new String[] { "i", "drink", "water" },
      new String[] { "want", "to" }, new String[]
        { "i", "want", "to", "drink", "water" }));
    System.out.println(instance.solution(
      new String[] { "i", "water", "drink" },
      new String[] { "want", "to" },
      new String[] { "i", "want", "to", "drink", "water" }));
  }

  public String solution(String[] cards1, String[] cards2, String[] goal) {
    Queue<String> first = new LinkedList<>(List.of(cards1)), second = new LinkedList<>(List.of(cards2));
    for (String current : goal) {
      if (notContains(first, current) && notContains(second, current)) {
        return "No";
      }
    }
    return "Yes";
  }

  private boolean notContains(Queue<String> queue, String current) {
    boolean notContains = queue.isEmpty() || !queue.peek().equals(current);
    if (!notContains) {
      queue.poll();
    }
    return notContains;
  }
}

/*
time complexity
O(N)

critical point
결과에서 각 카드 뭉치의 요소 순서 스캔

reference
https://school.programmers.co.kr/learn/courses/30/lessons/159994
*/
