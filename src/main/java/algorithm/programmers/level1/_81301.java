package algorithm.programmers.level1;

/**
 * 숫자 문자열과 영단어
 */
public class _81301 {

  public static void main(String[] args) {
    _81301 instance = new _81301();
    System.out.println(instance.solution("one4seveneight"));
    System.out.println(instance.solution("23four5six7"));
    System.out.println(instance.solution("2three45sixseven"));
    System.out.println(instance.solution("123"));
  }

  public int solution(String s) {
    String[] arr = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    for (int i = 0; i < arr.length; i++) {
      if (s.contains(arr[i])) {
        s = s.replaceAll(arr[i], String.valueOf(i));
      }
    }
    return Integer.parseInt(s);
  }
}

/*
time complexity
O(n)

critical point
포함 -> contains, 대치 -> replace
간단하게 풀기!!

reference
https://programmers.co.kr/learn/courses/30/lessons/81301
*/
