package algorithm.programmers.level1;

/**
 * 크기가 작은 부분문자열
 */
public class _147355 {

  public static void main(String[] args) {
    _147355 instance = new _147355();
    System.out.println(instance.solution("3141592", "271"));
    System.out.println(instance.solution("500220839878", "7"));
    System.out.println(instance.solution("10203", "15"));
  }

  public int solution(String t, String p) {
    long target = Long.parseLong(p);
    int answer = 0, size = t.length() - p.length() + 1;
    for (int i = 0; i < size; i++) {
      if (Long.parseLong(t.substring(i, i + p.length())) <= target) {
        ++answer;
      }
    }
    return answer;
  }
}

/*
time complexity
O(N)

critical point
범위 주의

reference
https://programmers.co.kr/learn/courses/30/lessons/147355
*/
