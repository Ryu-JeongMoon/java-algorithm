package algorithm.programmers.level1;

/**
 * 문자열 나누기
 */
public class _140108 {

  public static void main(String[] args) {
    _140108 instance = new _140108();
    System.out.println(instance.solution("banana"));
    System.out.println(instance.solution("abracadabra"));
    System.out.println(instance.solution("aaabbaccccabba"));
  }

  public int solution(String s) {
    int answer = 0, x = 0, initial = 0;
    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      if (x == 0) {
        initial = current;
        ++x;
      } else if (current == initial) {
        ++x;
      } else {
        --x;
      }

      if (x == 0) {
        ++answer;
      }
    }
    return x != 0 ? answer + 1 : answer;
  }
}

/*
time complexity
O(N)

critical point
짝이 안 맞는 경우도 고려해야 함

reference
https://school.programmers.co.kr/learn/courses/30/lessons/140108
*/
