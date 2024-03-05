package algorithm.programmers.level1;

import java.util.Arrays;

/**
 * 비밀지도
 */
public class _17681 {

  public static void main(String[] args) {
    _17681 instance = new _17681();
    System.out.println(Arrays.toString(instance.solution(5, new int[] { 9, 20, 28, 18, 11 }, new int[] { 30, 1, 21, 17, 28 })));
    System.out.println(Arrays.toString(instance.solution(6, new int[] { 46, 33, 33, 22, 31, 50 }, new int[] { 27, 56, 19, 14, 14, 10 })));
  }

  public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      char[] chars = Integer.toBinaryString(arr1[i] | arr2[i]).toCharArray();

      sb.append(" ".repeat(Math.max(0, n - chars.length)));
      for (char binary : chars) {
        sb.append(binary == '1' ? "#" : " ");
      }

      answer[i] = sb.toString();
      sb.setLength(0);
    }
    return answer;
  }
}

/*
time complexity
O(N^2)

critical point
비트 연산자 사용

reference
https://school.programmers.co.kr/learn/courses/30/lessons/17681
*/
