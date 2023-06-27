package algorithm.programmers.level1;

import java.util.Arrays;

/**
 * 모의고사
 */
public class _42840 {

  public static void main(String[] args) {
    _42840 instance = new _42840();
    System.out.println(Arrays.toString(instance.solution(new int[] { 1, 2, 3, 4, 5 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 1, 3, 2, 4, 2 })));
  }

  public int[] solution(int[] answers) {
    int[] a = { 1, 2, 3, 4, 5 };
    int[] b = { 2, 1, 2, 3, 2, 4, 2, 5 };
    int[] c = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

    int[] scores = new int[3];
    for (int i = 0; i < answers.length; i++) {
      if (answers[i] == a[i % a.length]) {
        ++scores[0];
      }
      if (answers[i] == b[i % b.length]) {
        ++scores[1];
      }
      if (answers[i] == c[i % c.length]) {
        ++scores[2];
      }
    }

    int max = 0, concurrentScorers = 0;
    for (int score : scores) {
      if (max < score) {
        max = score;
        concurrentScorers = 0;
      } else if (max == score) {
        ++concurrentScorers;
      }
    }

    int[] highScorers = new int[concurrentScorers + 1];
    for (int i = scores.length - 1; i >= 0; i--) {
      if (scores[i] == max) {
        highScorers[concurrentScorers--] = i + 1;
      }
    }
    return highScorers;
  }
}

/*
time complexity
O(n)

critical point
index 변수 추가하지 않기 위한 역순 삽입
int[] highScorers = new int[concurrentScorers + 1];
for (int i = scores.length - 1; i >= 0; i--) {
  if (scores[i] == max) {
    highScorers[concurrentScorers--] = i + 1;
  }
}

reference
https://programmers.co.kr/learn/courses/30/lessons/42840
*/
