package algorithm.inflearn;

import java.util.HashSet;

/**
 * 서로 다른 빈도수 만들기
 */
public class _2_3 {

  public static void main(String[] args) {
    System.out.println(solution("aaabbbcc"));
    System.out.println(solution("aaabbc"));
    System.out.println(solution("aebbbbc"));
    System.out.println(solution("aaabbbcccde"));
    System.out.println(solution("aaabbbcccdddeeeeeff"));
  }

  public static int solution(String s) {
    byte[] count = new byte[26];
    for (int i = 0; i < s.length(); i++) {
      ++count[s.charAt(i) - 'a'];
    }

    int answer = 0;
    HashSet<Integer> set = new HashSet<>();
    for (int b : count) {
      if (b == 0) {
        continue;
      }

      int key = b;
      while (set.contains(key)) {
        --key;
        ++answer;
      }

      if (key != 0) {
        set.add(key);
      }
    }

    return answer;
  }
}

/*
time complexity
O(N)

critical point
빈도수가 고유해야 하므로 빈도수를 키로 매핑
어떤 방식으로 빼든 빼야하는 횟수는 같으므로
겹친다면 키가 겹치지 않을 때 or 0일 때까지 뺌 (없애버림)

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=149846&category=questionDetail
 */
