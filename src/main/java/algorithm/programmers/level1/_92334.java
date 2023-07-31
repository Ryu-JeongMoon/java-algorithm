package algorithm.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 신고 결과 받기
 */
public class _92334 {

  public static void main(String[] args) {
    _92334 instance = new _92334();
    System.out.println(Arrays.toString(instance.solution(
      new String[] { "muzi", "frodo", "apeach", "neo" }, new String[] { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" }, 2)));
    System.out.println(Arrays.toString(instance.solution(
      new String[] { "con", "ryan" }, new String[] { "ryan con", "ryan con", "ryan con", "ryan con" }, 3)));
  }

  public int[] solution(String[] ids, String[] report, int k) {
    Map<String, Set<String>> reporterAndBullies = new HashMap<>();
    Map<String, Integer> numberOfReports = new HashMap<>();

    Set<String> reports = new HashSet<>(Arrays.asList(report));
    StringTokenizer tokenizer;
    for (String s : reports) {
      tokenizer = new StringTokenizer(s);
      String reporter = tokenizer.nextToken();
      String bully = tokenizer.nextToken();

      Set<String> bullies = reporterAndBullies.getOrDefault(reporter, new HashSet<>());
      bullies.add(bully);
      reporterAndBullies.put(reporter, bullies);
      numberOfReports.put(bully, numberOfReports.getOrDefault(bully, 0) + 1);
    }

    int[] answer = new int[ids.length];
    for (int i = 0; i < ids.length; i++) {
      int count = 0;
      Set<String> bullies = reporterAndBullies.getOrDefault(ids[i], new HashSet<>());
      for (String bully : bullies) {
        if (numberOfReports.getOrDefault(bully, 0) >= k) {
          ++count;
        }
      }
      if (count != 0) {
        answer[i] = count;
      }
    }

    return answer;
  }
}

/*
time complexity
N = ids.length
R = report.length
O(N) or O(R)

critical point
중복 신고는 불가능, 중복 요소 미리 제거

reference
https://programmers.co.kr/learn/courses/30/lessons/92334
*/
