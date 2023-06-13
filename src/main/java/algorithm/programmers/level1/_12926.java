package algorithm.programmers.level1;

/**
 * 시저 암호
 */
public class _12926 {

  public static void main(String[] args) {
    _12926 instance = new _12926();
    System.out.println(instance.solution("AB", 1));
    System.out.println(instance.solution("z", 1));
    System.out.println(instance.solution("a B z", 4));
  }

  public String solution(String sentence, int interval) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < sentence.length(); i++) {
      char c = sentence.charAt(i);
      if (c == ' ') {
        sb.append(c);
        continue;
      }

      if ((c <= 'Z' && c + interval > 'Z') || (c <= 'z' && c + interval > 'z')) {
        c -= 26;
      }
      sb.append((char) (c + interval));
    }
    return sb.toString();
  }
}

/*
time complexity
O(sentence.length)

critical point
a <= input <= z, A <= input <= Z
두 가지 상황에서 각각의 범위를 넘어가는 경우 맨 앞 문자로 돌아가야 함

reference
https://programmers.co.kr/learn/courses/30/lessons/12926
*/
