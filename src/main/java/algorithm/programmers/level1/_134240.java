package algorithm.programmers.level1;

/**
 * 푸드 파이트 대회
 */
public class _134240 {

  public static void main(String[] args) {
    _134240 instance = new _134240();
    System.out.println(instance.solution(new int[] { 1, 3, 4, 6 }));
    System.out.println(instance.solution(new int[] { 1, 7, 1, 2 }));
  }

  public String solution(int[] food) {
    StringBuilder front = new StringBuilder();
    for (int i = 1; i < food.length; i++) {
      front.append(String.valueOf(i).repeat(food[i] / 2));
    }
    return front + "0" + front.reverse();
  }
}

/*
time complexity
O(N)

critical point
문자열 뒤집기

reference
https://school.programmers.co.kr/learn/courses/30/lessons/134240
*/
