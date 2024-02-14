package algorithm.programmers.level1;

/**
 * 콜라 문제
 */
public class _132267 {

  public static void main(String[] args) {
    _132267 instance = new _132267();
    System.out.println(instance.solution(2, 1, 20));
    System.out.println(instance.solution(3, 1, 20));
    System.out.println(instance.solution(8, 1, 20));
  }

  public int solution(int a, int b, int n) {
    int answer = 0;
    while (n >= a) {
      int returning = n / a * b, remains = n % a;
      answer += returning;
      n = returning + remains;
    }
    return answer;
  }
}

/*
time complexity
O(logN)

critical point
상수로 푸는 방법 존재?!
(n - b) / (a - b) * b;

reference
https://school.programmers.co.kr/learn/courses/30/lessons/132267
*/
