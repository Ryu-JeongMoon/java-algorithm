package algorithm.inflearn;

/**
 * 한 번 사용한 최초문자
 */
public class _2_1 {

  public static void main(String[] args) {
    System.out.println(solution("statitsics"));
    System.out.println(solution("aabb"));
    System.out.println(solution("stringshowtime"));
    System.out.println(solution("abcdeabcdfg"));
  }

  public static int solution(String s) {
    byte[] count = new byte[26];
    for (int i = 0; i < s.length(); i++) {
      ++count[s.charAt(i) - 'a'];
    }

    for (int i = 0; i < s.length(); i++) {
      if (count[s.charAt(i) - 'a'] == 1) {
        return i + 1;
      }
    }

    return -1;
  }
}

/*
time complexity
O(n)

critical point
알파벳 순 순서가 아닌 인수로 주어진 문자열에서의 인덱스를 구해야 함

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=149842
 */
