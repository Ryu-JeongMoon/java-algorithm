package algorithm.programmers.level3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 단어 변환
 */
public class _43163_1 {

  public static void main(String[] args) {
    _43163_1 instance = new _43163_1();
    System.out.println(instance.solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));
    System.out.println(instance.solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log" }));
  }

  public int solution(String begin, String target, String[] words) {
    Set<String> wordSet = new HashSet<>(List.of(words));
    Set<String> visited = new HashSet<>();
    if (!wordSet.contains(target)) {
      return 0;
    }

    while (!begin.equals(target)) {
      String temp = begin;
      for (int i = 0; i < begin.length(); i++) {
        if (begin.charAt(i) == target.charAt(i)) {
          continue;
        }
        String alternative = begin.substring(0, i) + target.charAt(i) + begin.substring(i + 1);
        if (wordSet.contains(alternative)) {
          begin = alternative;
          visited.add(begin);
        }
      }

      if (temp.equals(begin)) {
        for (String word : words) {
          if (!visited.contains(word) && isConvertable(begin, word)) {
            begin = word;
            visited.add(begin);
            break;
          }
        }
      }
    }

    return visited.size();
  }

  private boolean isConvertable(String source, String target) {
    int diff = 0;
    for (int i = 0; i < source.length(); i++) {
      if (source.charAt(i) != target.charAt(i) && ++diff > 1) {
        return false;
      }
    }
    return diff == 1;
  }
}

/*
time complexity
n = words.length
O(n^2)

critical point
hit -> hot -> dot -> dog -> cog
위 과정에 연결 고리가 더 이상 존재 하지 않는 hot -> dot 어떻게 바꿀 것인가?

reference
https://programmers.co.kr/learn/courses/30/lessons/43163
*/
