package algorithm.programmers.level1;

import java.util.Arrays;

/**
 * 명예의 전당 (1)
 */
public class _138477 {

  public static void main(String[] args) {
    _138477 instance = new _138477();
    System.out.println(Arrays.toString(instance.solution(3, new int[] { 10, 100, 20, 150, 1, 100, 200 })));
    System.out.println(Arrays.toString(instance.solution(4, new int[] { 0, 300, 40, 300, 20, 70, 150, 50, 500, 1000 })));
    System.out.println(Arrays.toString(instance.solution(16, new int[] { 100, 30, 40, 150, 300, 200, 200 })));
  }

  public int[] solution(int k, int[] score) {
    int[] rank = new int[k];
    int min = Integer.MAX_VALUE, length = Math.min(k, score.length);
    for (int i = 0; i < length; i++) {
      rank[i] = score[i];
      score[i] = min = Math.min(min, rank[i]);
    }
    Arrays.sort(rank);

    for (int i = k; i < score.length; i++) {
      if (rank[0] < score[i]) {
        rank[0] = score[i];
        Arrays.sort(rank);
      }
      score[i] = rank[0];
    }
    return score;
  }
}

/*
time complexity
O(NlogN)

critical point
k가 score 보다 길 수 있다 ?!
제약 조건 주의하기

reference
https://school.programmers.co.kr/learn/courses/30/lessons/138477
*/
