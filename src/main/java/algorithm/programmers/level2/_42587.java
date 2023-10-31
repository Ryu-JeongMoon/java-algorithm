package algorithm.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/**
 * 프로세스
 */
public class _42587 {

  public static void main(String[] args) {
    _42587 instance = new _42587();
    System.out.println(instance.solution(new int[] { 2, 1, 3, 2 }, 2));
    System.out.println(instance.solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0));
    System.out.println(instance.solution(new int[] { 2, 1, 2, 1, 2, 1, 2, 1, 2 }, 1));
  }

  public int solution(int[] priorities, int location) {
    Queue<Integer> queue = new LinkedList<>(), indexes = new LinkedList<>();
    TreeSet<Integer> prioritySet = new TreeSet<>();
    for (int i = 0; i < priorities.length; i++) {
      indexes.offer(i);
      queue.offer(priorities[i]);
      prioritySet.add(priorities[i]);
    }

    int count = 0;
    while (indexes.contains(location)) {
      while (queue.peek() != prioritySet.last()) {
        queue.offer(queue.poll());
        indexes.offer(indexes.poll());
      }
      queue.poll();
      indexes.poll();
      if (!queue.contains(prioritySet.last())) {
        prioritySet.pollLast();
      }
      ++count;
    }
    return count;
  }
}

/*
time complexity
O(N^2)

critical point

reference
https://school.programmers.co.kr/learn/courses/30/lessons/42587
*/
