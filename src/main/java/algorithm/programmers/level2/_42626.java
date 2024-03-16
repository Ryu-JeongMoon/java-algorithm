package algorithm.programmers.level2;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 더 맵게
 */
public class _42626 {

  public static void main(String[] args) {
    _42626 instance = new _42626();
    System.out.println(instance.solution(new int[] { 0, 1 }, 1));
    System.out.println(instance.solution(new int[] { 1, 2 }, 5));
    System.out.println(instance.solution(new int[] { 0, 0, 0, 0, 1 }, 3));
    System.out.println(instance.solution(new int[] { 0, 0, 5, 5, 5 }, 2));
    System.out.println(instance.solution(new int[] { 1, 1, 1, 1, 1 }, 7));
    System.out.println(instance.solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7));
    System.out.println(instance.solution(new int[] { 1, 2, 3, 4, 9, 10, 12 }, 7));
    System.out.println(instance.solution(new int[] { 1, 2, 3, 4, 9, 10, 12 }, 148));
    System.out.println(instance.solution(new int[] { 1, 2, 3, 4, 9, 10, 12 }, 149));
  }

  public int solution(int[] scoville, int K) {
    Queue<Integer> mildFoods = new PriorityQueue<>();
    for (int food : scoville) {
      if (food < K) {
        mildFoods.offer(food);
      }
    }

    int count = 0, passed = scoville.length - mildFoods.size();
    while (mildFoods.size() >= 2) {
      int newScoville = mildFoods.poll() + mildFoods.poll() * 2;
      if (newScoville < K) {
        mildFoods.offer(newScoville);
      } else {
        ++passed;
      }
      ++count;
    }

    return mildFoods.isEmpty() || passed != 0 ? mildFoods.size() + count : -1;
  }
}

/*
time complexity
O(NlogN)

critical point
[0,1] 1 edge case

reference
https://school.programmers.co.kr/learn/courses/30/lessons/42626
*/
