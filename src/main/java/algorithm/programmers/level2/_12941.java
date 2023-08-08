package algorithm.programmers.level2;

import java.util.Arrays;

/**
 * 최솟값 만들기
 */
public class _12941 {

  public static void main(String[] args) {
    _12941 instance = new _12941();
    System.out.println(instance.solution(new int[] { 1, 4, 2 }, new int[] { 5, 4, 4 }));
    System.out.println(instance.solution(new int[] { 1, 2 }, new int[] { 3, 4 }));
  }

  public int solution(int[] A, int[] B) {
    Arrays.sort(A);
    Arrays.sort(B);
    int answer = 0;
    for (int i = 0; i < A.length; i++) {
      answer += (A[i] * B[A.length - i - 1]);
    }
    return answer;
  }
}

/*
time complexity
O(NlogN)

critical point
주어진 배열에 두 수를 골라 곱했을 때 가장 작은 값이 되도록 해야 함

reference
https://programmers.co.kr/learn/courses/30/lessons/12941
*/
