package algorithm.programmers.level2;

import java.util.Arrays;

/**
 * n^2 배열 자르기
 */
public class _87390 {

  public static void main(String[] args) {
    _87390 instance = new _87390();
    System.out.println(Arrays.toString(instance.solution(3, 2, 5)));
    System.out.println(Arrays.toString(instance.solution(4, 7, 14)));
  }

  public int[] solution(int n, long left, long right) {
    int currentRow = (int) (left / n), currentCol = (int) (left % n);
    int[] answer = new int[(int) (right - left + 1)];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = Math.max(currentRow, currentCol) + 1;

      if (++currentCol == n) {
        currentCol = 0;
        ++currentRow;
      }
    }
    return answer;
  }
}

/*
time complexity
O(right-left)

critical point
n^2 배열에서 행 / 열에 따라 들어갈 값을 O(n^2)으로 미리 연산하지 않고
인덱스에 따라 행 / 열을 지연 연산

left를 시작으로 반복문 안에서 left/n, left%n으로 행, 열을 계산하는 것보다
미리 현재 행, 열을 구한 후 반복문 안에서 행, 열을 증가시키는 것이 더 효율적

reference
https://school.programmers.co.kr/learn/courses/30/lessons/87390
*/
