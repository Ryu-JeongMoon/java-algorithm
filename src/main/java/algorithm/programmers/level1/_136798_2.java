package algorithm.programmers.level1;

/**
 * 기사단원의 무기
 */
public class _136798_2 {

  public static void main(String[] args) {
    _136798_2 instance = new _136798_2();
    System.out.println(instance.solution(5, 3, 2));
    System.out.println(instance.solution(10, 3, 2));
  }

  public int solution(int number, int limit, int power) {
    int[] count = new int[number + 1];
    for (int i = 1; i <= number; i++) {
      for (int j = 1; j <= number / i; j++) {
        count[i * j]++;
      }
    }

    int answer = 0;
    for (int i = 1; i <= number; i++) {
      answer += count[i] > limit ? power : count[i];
    }
    return answer;
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
