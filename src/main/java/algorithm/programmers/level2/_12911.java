package algorithm.programmers.level2;

/**
 * 다음 큰 숫자
 */
public class _12911 {

  public static void main(String[] args) {
    _12911 instance = new _12911();
    System.out.println(instance.solution(78));
    System.out.println(instance.solution(15));
  }

  public int solution(int n) {
    int initialCount = Integer.bitCount(n);
    while (Integer.bitCount(++n) != initialCount) {
    }
    return n;
  }
}

/*
time complexity
O(1)

critical point
Integer.bitCount() : 2진수로 변환했을 때 1의 개수를 반환하는 메소드

reference
https://school.programmers.co.kr/learn/courses/30/lessons/12911
*/
