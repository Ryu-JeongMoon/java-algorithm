package algorithm.programmers.level1;

import java.util.Arrays;

/**
 * 실패율
 */
public class _42889 {

  public static void main(String[] args) {
    _42889 instance = new _42889();
    System.out.println(Arrays.toString(instance.solution(5, new int[] { 2, 1, 2, 6, 2, 4, 3, 3 })));
    System.out.println(Arrays.toString(instance.solution(4, new int[] { 4, 4, 4, 4, 4 })));
  }

  public int[] solution(int N, int[] stages) {
    // number, failed, reached
    int[][] peoplePerStage = new int[N][3];
    for (int i = 0; i < peoplePerStage.length; i++) {
      peoplePerStage[i][0] = i;
    }

    for (int stage : stages) {
      for (int i = 0; i < stage; i++) {
        if (i == N) {
          break;
        }
        ++peoplePerStage[i][2];
      }

      if (stage <= N) {
        ++peoplePerStage[stage - 1][1];
      }
    }

    Arrays.sort(peoplePerStage, (a, b) -> {
      if (a[2] == 0 || b[2] == 0) {
        return a[2] == 0 ? 1 : -1;
      } else if ((double) a[1] / a[2] == (double) b[1] / b[2]) {
        return a[0] - b[0];
      } else {
        return (double) b[1] / b[2] - (double) a[1] / a[2] > 0 ? 1 : -1;
      }
    });

    int[] answer = new int[N];
    for (int i = 0; i < peoplePerStage.length; i++) {
      answer[i] = peoplePerStage[i][0] + 1;
    }
    return answer;
  }
}

/*
time complexity
O(NlogN)

critical point
스테이지 순회하며 현재 스테이지 보다 작은 스테이지 도달한 사람 수 증가

reference
https://school.programmers.co.kr/learn/courses/30/lessons/42889
*/
