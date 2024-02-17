package algorithm.programmers.level1;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 명예의 전당 (1)
 */
public class _138477_2 {

  public static void main(String[] args) {
    _138477_2 instance = new _138477_2();
    System.out.println(Arrays.toString(instance.solution(3, new int[] { 10, 100, 20, 150, 1, 100, 200 })));
    System.out.println(Arrays.toString(instance.solution(4, new int[] { 0, 300, 40, 300, 20, 70, 150, 50, 500, 1000 })));
    System.out.println(Arrays.toString(instance.solution(3, new int[] { 100, 30, 40, 150, 300, 200, 200 })));
  }

  public int[] solution(int k, int[] score) {
    PriorityQueue<Integer> rank = new PriorityQueue<>(k);
    for (int i = 0; i < score.length; i++) {
      if (rank.size() < k) {
        rank.add(score[i]);
      } else if (rank.peek() < score[i]) {
        rank.poll();
        rank.add(score[i]);
      }
      score[i] = rank.peek();
    }
    return score;
  }
}

/*
time complexity
O(NlogK)

critical point
정렬 보장 & 중복 허용 -> PriorityQueue 사용

reference
https://school.programmers.co.kr/learn/courses/30/lessons/138477
*/
