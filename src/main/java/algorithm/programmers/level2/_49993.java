package algorithm.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 스킬 트리
 */
public class _49993 {

  public static void main(String[] args) {
    _49993 instance = new _49993();
    System.out.println(instance.solution("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA" }));
    System.out.println(instance.solution("CBD", new String[] { "CAD" }));
    System.out.println(instance.solution("CBD", new String[] { "AEF", "ZJW" }));
    System.out.println(instance.solution("REA", new String[] { "REA", "POA" }));
    System.out.println(instance.solution("CBDK", new String[] { "CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK" }));
    System.out.println(instance.solution("BDC", new String[] { "AAAABACA" }));
    System.out.println(instance.solution("CBD", new String[] { "C", "D", "CB", "BDA" }));
  }

  public int solution(String skill, String[] skillTrees) {
    int answer = 0;
    for (String skillTree : skillTrees) {
      int learningIdx = 0;
      boolean isLearnable = true;
      for (char current : skillTree.toCharArray()) {
        int skillIdx = skill.indexOf(current);
        if (skillIdx == -1) {
          continue;
        }

        if (skillIdx == learningIdx) {
          learningIdx++;
        } else {
          isLearnable = false;
          break;
        }
      }

      if (isLearnable) {
        answer++;
      }
    }
    return answer;
  }

  public int solutionByReplaceAll(String skill, String[] skillTrees) {
    String regexp = "[^%s]".formatted(skill);
    int answer = 0;
    for (String skillTree : skillTrees) {
      if (skill.startsWith(skillTree.replaceAll(regexp, ""))) {
        ++answer;
      }
    }
    return answer;
  }

  public int solutionByQueue(String skill, String[] skillTrees) {
    Queue<Character> queue = new LinkedList<>();
    for (int i = 0; i < skill.length(); i++) {
      queue.offer(skill.charAt(i));
    }

    int answer = 0, matches;
    char first = skill.charAt(0);
    for (String skillTree : skillTrees) {
      matches = 1;
      for (int i = 0; i < skillTree.length(); i++) {
        char current = skillTree.charAt(i);
        if (queue.contains(current)) {
          if (queue.peek() != current) {
            matches = 0;
            break;
          } else {
            queue.offer(queue.poll());
          }
        }
      }

      while (queue.peek() != first) {
        queue.offer(queue.poll());
      }

      if (matches == 1) {
        ++answer;
      }
    }
    return answer;
  }
}

/*
solution                               solutionByReplaceAll                   solutionByQueue
테스트 1  〉	통과 (0.04ms, 76.7MB)    테스트 1  〉	통과 (1.04ms, 66.4MB)     테스트 1  〉	통과 (0.19ms, 58.4MB)
테스트 2  〉	통과 (0.04ms, 74.3MB)    테스트 2  〉	통과 (1.01ms, 75MB)       테스트 2  〉	통과 (0.29ms, 72.3MB)
테스트 3  〉	통과 (0.03ms, 68.8MB)    테스트 3  〉	통과 (0.97ms, 71.9MB)     테스트 3  〉	통과 (0.33ms, 77.1MB)
테스트 4  〉	통과 (0.03ms, 75.7MB)    테스트 4  〉	통과 (1.26ms, 75.3MB)     테스트 4  〉	통과 (0.24ms, 91.7MB)
테스트 5  〉	통과 (0.03ms, 73.6MB)    테스트 5  〉	통과 (1.44ms, 74MB)       테스트 5  〉	통과 (0.26ms, 75.9MB)
테스트 6  〉	통과 (0.04ms, 76.1MB)    테스트 6  〉	통과 (1.09ms, 70MB)       테스트 6  〉	통과 (0.20ms, 72.2MB)
테스트 7  〉	통과 (0.03ms, 75.7MB)    테스트 7  〉	통과 (1.24ms, 77.3MB)     테스트 7  〉	통과 (0.33ms, 75MB)
테스트 8  〉	통과 (0.02ms, 67.3MB)    테스트 8  〉	통과 (1.46ms, 75.7MB)     테스트 8  〉	통과 (0.29ms, 73.5MB)
테스트 9  〉	통과 (0.04ms, 74.5MB)    테스트 9  〉	통과 (1.04ms, 72.7MB)     테스트 9  〉	통과 (0.24ms, 76.2MB)
테스트 10 〉	통과 (0.04ms, 76.5MB)    테스트 10 〉	통과 (1.05ms, 74.8MB)     테스트 10 〉	통과 (0.23ms, 75.9MB)
테스트 11 〉	통과 (0.05ms, 85.7MB)    테스트 11 〉	통과 (1.48ms, 72.1MB)     테스트 11 〉	통과 (0.24ms, 72.8MB)
테스트 12 〉	통과 (0.03ms, 78.6MB)    테스트 12 〉	통과 (1.87ms, 78.5MB)     테스트 12 〉	통과 (0.37ms, 72.5MB)
테스트 13 〉	통과 (0.05ms, 76.3MB)    테스트 13 〉	통과 (1.17ms, 76.5MB)     테스트 13 〉	통과 (0.31ms, 77.1MB)
테스트 14 〉	통과 (0.03ms, 79.4MB)    테스트 14 〉	통과 (1.53ms, 76.4MB)     테스트 14 〉	통과 (0.22ms, 75.7MB)

time complexity
M = average length of skillTrees
O(N*M)

critical point
스킬은 반드시 정순으로 배워야 하며 다 배우지 않아도 되므로 startsWith 사용

reference
https://programmers.co.kr/learn/courses/30/lessons/49993
*/
