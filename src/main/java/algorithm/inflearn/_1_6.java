package algorithm.inflearn;

import java.util.Arrays;

/**
 * 과일 가져가기
 */
public class _1_6 {

  public static void main(String[] args) {
    int[][] p1 = { { 10, 20, 30 }, { 12, 15, 20 }, { 20, 12, 15 }, { 15, 20, 10 }, { 10, 15, 10 } };
    int[][] p2 = { { 10, 9, 11 }, { 15, 20, 25 } };
    int[][] p3 = { { 0, 3, 27 }, { 20, 5, 5 }, { 19, 5, 6 }, { 10, 10, 10 }, { 15, 10, 5 }, { 3, 7, 20 } };
    int[][] p4 = { { 3, 7, 20 }, { 10, 15, 5 }, { 19, 5, 6 }, { 10, 10, 10 }, { 15, 10, 5 }, { 3, 7, 20 }, { 12, 12, 6 }, { 10, 20, 0 }, { 5, 10, 15 } };

    System.out.println(solution(p1));
    System.out.println(solution(p2));
    System.out.println(solution(p3));
    System.out.println(solution(p4));
  }

  public static int solution(int[][] fruit) {
    // minimumIndexes should not be initialized with 0,
    // 0 can be actual value of minimum index (it can be 0, 1, 2)
    int[] minimumIndexes = new int[fruit.length];
    Arrays.fill(minimumIndexes, Integer.MAX_VALUE);

    boolean[] exchanged = new boolean[fruit.length];
    boolean[] canBeExchanged = new boolean[fruit.length];

    for (int i = 0; i < fruit.length; i++) {
      if (exchanged[i]) {
        continue;
      }

      minimumIndexes[i] = minimumIndexes[i] != Integer.MAX_VALUE
        ? minimumIndexes[i]
        : findIndexOfMinimumValue(fruit, i, canBeExchanged);

      if (!canBeExchanged[i]) {
        continue;
      }

      for (int j = i + 1; j < fruit.length; j++) {
        if (exchanged[j]) {
          continue;
        }

        minimumIndexes[j] = minimumIndexes[j] != Integer.MAX_VALUE
          ? minimumIndexes[j]
          : findIndexOfMinimumValue(fruit, j, canBeExchanged);

        if (canBeExchanged[j] && isMutuallyBeneficial(fruit, minimumIndexes, i, j)) {
          exchanged[i] = true;
          exchanged[j] = true;

          ++fruit[i][minimumIndexes[i]];
          --fruit[i][minimumIndexes[j]];
          ++fruit[j][minimumIndexes[j]];
          --fruit[j][minimumIndexes[i]];

          break;
        }
      }
    }

    int answer = 0;
    for (int i = 0; i < fruit.length; i++) {
      answer += fruit[i][minimumIndexes[i]];
    }
    return answer;
  }

  private static int findIndexOfMinimumValue(int[][] fruit, int i, boolean[] canExchanged) {
    int minValue = Integer.MAX_VALUE, minIndex = 0;
    for (int j = 0; j < fruit[i].length; j++) {
      if (fruit[i][j] < minValue) {
        minValue = fruit[i][j];
        minIndex = j;
      }
    }

    // it's not recommended pattern, but hidden state change happens here
    checkExchangeability(fruit, i, minIndex, canExchanged);
    return minIndex;
  }

  private static void checkExchangeability(int[][] fruit, int i, int minimumIndex, boolean[] canExchanged) {
    canExchanged[i] = true;
    for (int j = 0; j < fruit[i].length; j++) {
      // it can't be exchanged, otherwise minimumValue + 1 should be less than other values
      // minimumValue + 1 can be equal to other values, for example (1,2,2) -> (1+1,2,2)
      // so equal case should not be filtered out
      if (j != minimumIndex && fruit[i][j] < fruit[i][minimumIndex] + 1) {
        canExchanged[i] = false;
        return;
      }
    }
  }

  private static boolean isMutuallyBeneficial(int[][] fruit, int[] minimumIndexes, int i, int j) {
    // equal case like below can be filtered out here
    // (5,6,7) -> (6,5,7)
    return minimumIndexes[i] != minimumIndexes[j]
      && fruit[i][minimumIndexes[i]] + 1 <= fruit[i][minimumIndexes[j]] - 1
      && fruit[j][minimumIndexes[j]] + 1 <= fruit[j][minimumIndexes[i]] - 1;
  }
}

/*
time complexity

critical point
minimumIndexes, exchanged, canBeExchanged 세 가지 변수로 상태 관리
- minimumIndexes : 특정 학생의 과일 최소값 index 관리
- exchanged      : 특정 학생의 교환 유무 관리
- canBeExchanged : 특정 학생의 교환 여부 관리

minimumIndexes
0, 1, 2를 가질 수 있으므로 0으로 초기화해서는 안 됨
특정 값으로 초기화 후, 특정 값이 변하지 않았다면 연산이 수행되지 않은 것으로 판단하는 최적화 수행 가능

exchanged
i번째 학생, j번째 학생이 교환을 수행했다는 것을 기록하여 루프 내에서 연산이 반복되지 않도록 함

canBeExchanged
안티패턴이지만 편의를 위해 과일 최소값 인덱스를 찾을 때
교환 가능 여부의 상태 변경 로직을 함께 수행

1. i번째 학생에 대한 최소 인덱스를 찾고 교환 가능 여부를 확인
2. i번째 학생이 교환이 불가능하다면 (최소값이 2개 이상이라면 교환하더라도 이득이 없으므로 교환 불가능) 다음 학생으로 스킵
3. i번째 학생이 교환이 가능하다면 i+1번째 학생부터 개별적으로 2번 로직 수행 후 상호 이득 확인

상호 이득
i번째 학생과 j번째 학생이 교환을 수행했을 때 아래 조건을 만족시켜야 함
i번째 학생의 기존 최소 과일 개수 + 1 (받은 개수) <= j번째 학생한테 준 과일의 기존 개수 - 1 (준 개수)
5,6,7 -> 6,6,6 은 과일의 최소 개수가 증가했으므로 상호 이득을 만족시키고
5,6,7 -> 6,5,7 은 과일의 최소 개수가 변함 없으므로 상호 이득을 만족시키지 않음

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=149832
 */