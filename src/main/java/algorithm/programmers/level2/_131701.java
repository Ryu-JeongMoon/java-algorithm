package algorithm.programmers.level2;

import java.util.HashSet;
import java.util.Set;

/**
 * 연속 부분 수열 합의 개수
 */
public class _131701 {

  public static void main(String[] args) {
    _131701 instance = new _131701();
    System.out.println(instance.solution(new int[] { 7, 9, 1, 1, 4 }));
  }

  public int solution(int[] elements) {
    Set<Integer> sum = new HashSet<>();
    for (int i = 0; i < elements.length; i++) {
      int current = 0;
      for (int j = i; j < elements.length - 1 + i; j++) {
        current += elements[j % elements.length];
        sum.add(current);
      }
    }
    return sum.size() + 1;
  }
}

/*
time complexity
O(N^2)

critical point
모든 원소의 합은 반복해 더할 필요 없음
두번째 for-statement 에서 elements.length - 1 + i 를 하여 모든 원소 개수 - 1 까지 반복

reference
https://programmers.co.kr/learn/courses/30/lessons/131701
*/
