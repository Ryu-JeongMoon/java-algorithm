package algorithm.programmers.level2;

/**
 * 구명보트
 */
public class _42885 {

  public static void main(String[] args) {
    _42885 instance = new _42885();
    System.out.println(instance.solution(new int[] { 70, 50, 80, 50 }, 100));
    System.out.println(instance.solution(new int[] { 70, 80, 50 }, 100));
    System.out.println(instance.solution(new int[] { 70, 80, 50, 60, 50, 40 }, 110));
    System.out.println(instance.solution(new int[] { 40, 50, 150, 160 }, 200));
    System.out.println(instance.solution(new int[] { 30, 30, 60 }, 160));
    System.out.println(instance.solution(new int[] { 10, 50, 100 }, 160));
  }

  public int solution(int[] people, int limit) {
    int[] weights = new int[240];
    for (int weightOfPerson : people) {
      ++weights[weightOfPerson];
    }

    int count = 0;
    for (int weightOfPerson : people) {
      if (weights[weightOfPerson] == 0) {
        continue;
      }

      --weights[weightOfPerson];
      int pair = limit - weightOfPerson;
      for (int i = pair; i >= 0; i--) {
        if (weights[i] != 0) {
          --weights[i];
          break;
        }
      }

      ++count;
    }
    return count;
  }
}

/*
time complexity
O(N)

critical point
같이 탈 수 있는 최대 몸무게 찾기

reference
https://school.programmers.co.kr/learn/courses/30/lessons/42885
*/
