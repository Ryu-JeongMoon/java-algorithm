package algorithm.inflearn;

import java.util.Arrays;

/**
 * 회의실 만남
 */
public class _1_8 {

  private static final int ENTER = 0;
  private static final int EXIT = 1;

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(new int[]{ 1, 2, 3, 4 }, new int[]{ 2, 4, 1, 3 })));
    System.out.println(Arrays.toString(solution(new int[]{ 1, 2, 5, 3, 4 }, new int[]{ 2, 3, 1, 4, 5 })));
    System.out.println(Arrays.toString(solution(new int[]{ 1, 3, 2, 4, 5, 7, 6, 8 }, new int[]{ 2, 3, 5, 6, 1, 4, 8, 7 })));
    System.out.println(Arrays.toString(solution(new int[]{ 1, 4, 7, 2, 3, 5, 6 }, new int[]{ 5, 2, 6, 1, 7, 3, 4 })));
    System.out.println(Arrays.toString(solution(new int[]{ 1, 4, 2, 3 }, new int[]{ 2, 1, 4, 3 })));
  }

  public static int[] solution(int[] enter, int[] exit) {
    int[][] order = new int[2][enter.length];
    // it should start from 1, not 0
    // initialized with 0, but it is operated by prefix increment operator
    int time = 0;
    for (int x : exit) {
      for (int n : enter) {
        if (x == n) {
          order[ENTER][n - 1] = order[ENTER][n - 1] != 0 ? order[ENTER][n - 1] : ++time;
          order[EXIT][n - 1] = order[EXIT][n - 1] != 0 ? order[EXIT][n - 1] : ++time;
          break;
        } else {
          order[ENTER][n - 1] = order[ENTER][n - 1] != 0 ? order[ENTER][n - 1] : ++time;
        }
      }
    }

    int[] answer = new int[enter.length];
    for (int x : exit) {
      for (int n : enter) {
        if (x != n && !(order[EXIT][n - 1] < order[ENTER][x - 1] || order[EXIT][x - 1] < order[ENTER][n - 1])) {
          ++answer[x - 1];
        }
      }
    }
    return answer;
  }
}

/*
time complexity
O(n^2)

critical point
시간 흐름을 만들고, 만나지 않는 조건에 부정으로 표현
i, j 두 변수가 있을 때 두 가지 경우에 서로 만나지 않는다 할 수 있음
1. j가 i의 퇴장 후에 입장했을 때 exit[i] < enter[j]
2. i가 j의 퇴장 후에 입장했을 때 exit[j] < enter[i]

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=149836
 */