package algorithm.inflearn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 회장 선거
 */
public class _2_5 {

  public static void main(String[] args) {
    String[] votes1 = { "john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john" };
    String[] votes2 = { "john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park",
      "park john", "john park", "tom john", "tom park", "tom luis" };
    String[] votes3 = { "cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john" };
    String[] votes4 = { "bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis",
      "tom bob", "tom luis", "john park", "park john" };

    System.out.println(solution(votes1, 2));
    System.out.println(solution(votes2, 2));
    System.out.println(solution(votes3, 2));
    System.out.println(solution(votes4, 3));
  }

  public static String solution(String[] votes, int k) {
    HashMap<String, Set<String>> votesForPerson = new HashMap<>();
    for (String vote : votes) {
      String[] s = vote.split(" ");
      Set<String> supporters = votesForPerson.getOrDefault(s[1], new HashSet<>());
      supporters.add(s[0]);
      votesForPerson.put(s[1], supporters);
    }

    HashMap<String, Integer> presentsForPerson = new HashMap<>();
    for (Set<String> supporters : votesForPerson.values()) {
      if (supporters.size() >= k) {
        for (String supporter : supporters) {
          presentsForPerson.put(supporter, presentsForPerson.getOrDefault(supporter, 0) + 1);
        }
      }
    }

    String answer = "";
    int max = Integer.MIN_VALUE;
    for (String person : presentsForPerson.keySet()) {
      Integer presents = presentsForPerson.getOrDefault(person, 0);
      if (presents > max || (presents == max && person.compareTo(answer) < 0)) {
        max = presents;
        answer = person;
      }
    }
    return answer;
  }
}

/*
time complexity
O(N^2)

critical point
답이 여러명일 경우 사전순으로 가장 빠른 이름을 반환

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=149850
 */