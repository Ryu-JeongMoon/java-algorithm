package algorithm.inflearn;

import java.util.Arrays;

/**
 * 같은 빈도수 만들기
 */
public class _2_2 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution("aaabc")));
    System.out.println(Arrays.toString(solution("aabb")));
    System.out.println(Arrays.toString(solution("abcde")));
    System.out.println(Arrays.toString(solution("abcdeabc")));
    System.out.println(Arrays.toString(solution("abbccddee")));
  }

  public static int[] solution(String s) {
    int[] answer = new int[5];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < s.length(); i++) {
      max = Math.max(max, ++answer[s.charAt(i) - 'a']);
    }
    for (int i = 0; i < answer.length; i++) {
      answer[i] = max - answer[i];
    }
    return answer;
  }
}

/*
time complexity
O(n)

critical point
[최댓값 - 현재값] 배열

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=149844&category=questionDetail
 */
