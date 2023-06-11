package algorithm.programmers.level1;

import java.util.Arrays;

/**
 * 자연수 뒤집어 배열로 만들기
 */
public class _12932 {

  public static void main(String[] args) {
    _12932 instance = new _12932();
    System.out.println(Arrays.toString(instance.solution(12345)));
  }

  public int[] solution(long number) {
    return new StringBuilder()
      .append(number)
      .reverse()
      .chars()
      .map(Character::getNumericValue)
      .toArray();
  }
}

/*
time complexity
O(log10(number))

critical point

reference
https://programmers.co.kr/learn/courses/30/lessons/12932
*/
