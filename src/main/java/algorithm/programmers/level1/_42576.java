package algorithm.programmers.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * 완주하지 못한 선수
 */
public class _42576 {

  public static void main(String[] args) {
    _42576 instance = new _42576();
    System.out.println(instance.solution(new String[] { "leo", "kiki", "eden" }, new String[] { "eden", "kiki" }));
    System.out.println(instance.solution(
      new String[] { "marina", "josipa", "nikola", "vinko", "filipa" },
      new String[] { "josipa", "filipa", "marina", "nikola" }));
    System.out.println(instance.solution(
      new String[] { "mislav", "stanko", "mislav", "ana" },
      new String[] { "stanko", "ana", "mislav" }));
  }

  public String solution(String[] participants, String[] completions) {
    Map<String, Integer> finishers = new HashMap<>();
    for (String completion : completions) {
      finishers.put(completion, finishers.getOrDefault(completion, 0) + 1);
    }
    for (String participant : participants) {
      int finisher = finishers.getOrDefault(participant, 0);
      if (finisher == 0) {
        return participant;
      }
      finishers.put(participant, finisher - 1);
    }
    return "";
  }
}

/*
time complexity
O(N)

critical point
동명이인 처리를 위해 등장 횟수 계산

reference
https://programmers.co.kr/learn/courses/30/lessons/42576
*/
