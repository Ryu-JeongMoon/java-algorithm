package algorithm.programmers.level2;

import java.util.Arrays;

/**
 * 이진 변환 반복하기
 */
public class _70129 {

  public static void main(String[] args) {
    _70129 instance = new _70129();
    System.out.println(Arrays.toString(instance.solution("110010101001")));
    System.out.println(Arrays.toString(instance.solution("01110")));
    System.out.println(Arrays.toString(instance.solution("1111111")));
  }

  public int[] solution(String s) {
    int zeroCount = 0, transformCount = 0;
    while (!s.equals("1")) {
      int lengthAfterReplacing = s.replaceAll("0", "").length();
      zeroCount += (s.length() - lengthAfterReplacing);
      s = Integer.toBinaryString(lengthAfterReplacing);
      ++transformCount;
    }

    return new int[] { transformCount, zeroCount };
  }
}

/*
time complexity
O(n^2)

critical point
기존 문자열의 길이 - 변환 후 문자열의 길이 = 기존 문자열에 있던 0의 개수
기존 문자열을 나타내는 참조에는 변환 후 문자열의 길이를 2진수로 나타낸 것을 재할당

reference
https://programmers.co.kr/learn/courses/30/lessons/70129
*/
