package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 영어 끝말잇기
 */
public class _12981 {

  public static void main(String[] args) {
    _12981 instance = new _12981();
    System.out.println(Arrays.toString(instance.solution(3, new String[] { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" })));
    System.out.println(Arrays.toString(instance.solution(5, new String[] { "hello", "observe", "effect", "take", "either", "recognize", "encourage",
      "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive" })));
    System.out.println(Arrays.toString(instance.solution(2, new String[] { "hello", "one", "even", "never", "now", "world", "draw" })));
  }

  public int[] solution(int n, String[] words) {
    int length = words.length;
    Set<String> used = new HashSet<>(length);
    used.add(words[0]);
    for (int i = 1; i < length; i++) {
      String previous = words[i - 1], current = words[i];
      if (previous.charAt(previous.length() - 1) != current.charAt(0) || used.contains(current)) {
        return new int[] { i % n + 1, i / n + 1 };
      } else {
        used.add(current);
      }
    }
    return new int[] { 0, 0 };
  }
}

/*
time complexity
O(N)

critical point
번호와 차례는 0,1,2..가 아닌 1,2,3.. 순이기 때문에 i%n+1, i/n+1로 계산

reference
https://school.programmers.co.kr/learn/courses/30/lessons/12981
*/
