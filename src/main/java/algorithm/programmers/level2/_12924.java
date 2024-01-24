package algorithm.programmers.level2;

/**
 * 숫자의 표현
 */
public class _12924 {

  public static void main(String[] args) {
    _12924 instance = new _12924();
    System.out.println(instance.solution(15));
  }

  private int solution(int n) {
    int half = n / 2, count = 0, sum = 0;
    for (int i = 1; i <= half; i++) {
      for (int j = i; j <= half + 1; j++) {
        sum += j;
        if (sum >= n) {
          if (sum == n) {
            ++count;
          }
          sum = 0;
          break;
        }
      }
    }
    return count + 1;
  }
}

/*
time complexity
O(N^2)

critical point
연속된 수만 가능, 자기 자신은 예외 처리

reference
https://school.programmers.co.kr/learn/courses/30/lessons/12924
*/
