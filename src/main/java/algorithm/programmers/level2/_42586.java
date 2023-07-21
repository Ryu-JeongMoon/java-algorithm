package algorithm.programmers.level2;

import java.util.Arrays;

/**
 * 기능개발
 */
public class _42586 {

  public static void main(String[] args) {
    _42586 instance = new _42586();
    System.out.println(Arrays.toString(instance.solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 95, 90, 99, 99, 80, 99 }, new int[] { 1, 1, 1, 1, 1, 1 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 95, 90, 99, 98, 80, 99 }, new int[] { 1, 1, 1, 1, 1, 1 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 90, 90, 90, 90 }, new int[] { 30, 1, 1, 1 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 99, 99, 99, 90, 90, 90 }, new int[] { 1, 1, 1, 1, 1, 1 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 95, 95, 90, 99, 99, 80, 99 }, new int[] { 1, 1, 1, 1, 1, 1, 1 })));
  }

  public int[] solution(int[] progresses, int[] speeds) {
    int[] answer = new int[progresses.length];
    int count = 0, index = 0, workdays = 0, completion = 100;
    for (int i = 0; i < progresses.length; i++) {
      int currentProgress = progresses[i] + workdays * speeds[i];
      if (currentProgress >= completion) {
        ++count;
      } else {
        if (count != 0) {
          answer[index++] = count;
        }
        int insufficientProgress = completion - currentProgress;
        int toBeAddedWorkDays = insufficientProgress / speeds[i];
        workdays += insufficientProgress % speeds[i] == 0
          ? toBeAddedWorkDays
          : toBeAddedWorkDays + 1;
        count = 1;
      }
    }
    answer[index++] = count;
    return Arrays.copyOfRange(answer, 0, index);
  }

}

/*
time complexity
O(N)

critical point
100%에 미치지 못하는 작업 진도를 만난 경우
현재 작업 진도를 목표 작업 진도(100%)로 보정 & count 보정

reference
https://programmers.co.kr/learn/courses/30/lessons/42586
*/
