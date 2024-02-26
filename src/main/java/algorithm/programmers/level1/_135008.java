package algorithm.programmers.level1;

import java.util.Arrays;

/**
 * 과일 장수
 */
public class _135008 {

  public static void main(String[] args) {
    _135008 instance = new _135008();
    System.out.println(instance.solution(3, 4, new int[] { 1, 2, 3, 1, 2, 3, 1 }));
    System.out.println(instance.solution(4, 3, new int[] { 4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2 }));
  }

  public int solution(int k, int m, int[] score) {
    Arrays.sort(score);
    int answer = 0, length = score.length;
    while (length >= m) {
      length -= m;
      answer += score[length];
    }
    return answer * m;
  }
}

/*
time complexity
O(NlogN)

critical point
점수 별 정렬 후 가능한 큰 점수끼리 묶어서 계산

reference
https://school.programmers.co.kr/learn/courses/30/lessons/135808
*/
