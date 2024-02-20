package algorithm.programmers.level2;

/**
 * 예상 대진표
 */
public class _12985 {

  public static void main(String[] args) {
    _12985 instance = new _12985();
    System.out.println(instance.solution(8, 4, 7));
    System.out.println(instance.solution(16, 1, 7));
    System.out.println(instance.solution(32, 1, 9));
    System.out.println(instance.solution(32, 1, 17));
    System.out.println(instance.solution(1048576, 12345, 12346));
  }

  public int solution(int n, int a, int b) {
    int round = 0;
    while (a != b) {
      ++round;
      a = a / 2 + a % 2;
      b = b / 2 + b % 2;
    }
    return round;
  }
}

/*
time complexity
O(logN)

critical point
XOR 연산으로 계산 가능?!

reference
https://school.programmers.co.kr/learn/courses/30/lessons/12985
*/
