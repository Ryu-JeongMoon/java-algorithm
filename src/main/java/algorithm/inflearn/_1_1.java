package algorithm.inflearn;

import java.util.Arrays;

/**
 * 사다리 타기
 */
public class _1_1 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution2(5, new int[][]{ { 1, 3 }, { 2, 4 }, { 1, 4 } })));
    System.out.println(Arrays.toString(solution2(7, new int[][]{ { 1, 3, 5 }, { 1, 3, 6 }, { 2, 4 } })));
    System.out.println(Arrays.toString(solution2(8, new int[][]{ { 1, 5 }, { 2, 4, 7 }, { 1, 5, 7 }, { 2, 5, 7 } })));
    System.out.println(Arrays.toString(solution2(12, new int[][]{ { 1, 5, 8, 10 }, { 2, 4, 7 }, { 1, 5, 7, 9, 11 }, { 2, 5, 7, 10 }, { 3, 6, 8, 11 } })));
  }

  public static char[] solution1(int n, int[][] ladder) {
    char[] answer = new char[n];
    for (int i = 0; i < n; i++) {
      int currentIndex = i + 1;
      char currentChar = (char) (i + 65);
      for (int[] level : ladder) {
        for (int value : level) {
          if (value == currentIndex) {
            ++currentIndex;
            break;
          } else if (value == currentIndex - 1) {
            --currentIndex;
            break;
          }
        }
      }
      answer[currentIndex - 1] = currentChar;
    }
    return answer;
  }

  public static char[] solution2(int n, int[][] ladder) {
    char[] answer = new char[n];
    for (int i = 0; i < n; i++) {
      answer[i] = (char) (i + 65);
    }

    for (int[] line : ladder) {
      for (int i : line) {
        char temp = answer[i];
        answer[i] = answer[i - 1];
        answer[i - 1] = temp;
      }
    }
    return answer;
  }
}

/*
time complexity
ladder[0].length <= 10이므로 상수 취급, O(N)

critical point
1. 3 ≤ n ≤ 25
2. ladder.length <= 1,000
3. ladder[0].length <= 10

solution1
1. 현재 세로 인덱스가 1일 때, 사다리에서 가로줄 인덱스 1을 만나면 현재 세로 인덱스를 2로 변경
2. 현재 세로 인덱스가 2일 때, 사다리에서 가로줄 인덱스 1을 만나면 현재 세로 인덱스를 1로 변경

solution2
가로줄 탐색 시 1을 만났다면 answer 배열 index 0, 1 값을 swap

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=151383
 */