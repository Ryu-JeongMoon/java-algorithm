package algorithm.programmers.level1;

/**
 * 기사단원의 무기
 */
public class _136798 {

  public static void main(String[] args) {
    _136798 instance = new _136798();
    System.out.println(instance.solution(5, 3, 2));
    System.out.println(instance.solution(10, 3, 2));
  }

  public int solution(int number, int limit, int power) {
    int answer = 0;
    for (int i = 1; i <= number; i++) {
      int theNumberOfDivisor = getTheNumberOfDivisor(i);
      answer += theNumberOfDivisor > limit ? power : theNumberOfDivisor;
    }
    return answer;
  }

  private int getTheNumberOfDivisor(int number) {
    int result = 0, sqrt = (int) Math.sqrt(number);
    for (int i = 1; i <= sqrt; i++) {
      if (number % i == 0) {
        result += 2;
      }
    }
    return (int) Math.sqrt(number) == Math.sqrt(number) ? --result : result;
  }
}

/*
time complexity
O(N)

critical point
약수 계산 최적화 필요

reference
https://programmers.co.kr/learn/courses/30/lessons/136798
*/
