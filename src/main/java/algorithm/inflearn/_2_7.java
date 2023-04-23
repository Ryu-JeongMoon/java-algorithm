package algorithm.inflearn;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 경고 메일
 */
public class _2_7 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(
      new String[]{ "john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out",
        "daniel 15:05 out" }, 60)));
    System.out.println(Arrays.toString(solution(
      new String[]{ "bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out",
        "daniel 14:55 out" }, 120)));
    System.out.println(Arrays.toString(solution(
      new String[]{ "cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out",
        "luis 15:30 in", "luis 15:33 out" }, 70)));
    System.out.println(Arrays.toString(solution(
      new String[]{ "chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out",
        "daniel 15:05 out" }, 60)));
  }

  public static String[] solution(String[] reports, int time) {
    HashMap<String, Integer> periodForPerson = new HashMap<>();
    for (String report : reports) {
      String[] s = report.split(" ");
      int past = periodForPerson.getOrDefault(s[0], 0);
      int current = getTime(s[1]);
      periodForPerson.put(s[0], s[2].equals("in") ? past - current : past + current);
    }

    return periodForPerson.keySet().stream()
      .filter(k -> periodForPerson.get(k) > time)
      .sorted()
      .toList()
      .toArray(new String[]{});
  }

  private static int getTime(String time) {
    String[] hourAndMinute = time.split(":");
    return Integer.parseInt(hourAndMinute[0]) * 60 + Integer.parseInt(hourAndMinute[1]);
  }
}

/*
time complexity
O(NlogN)

critical point
한 사람이 보안실 여러번 이용 가능
여러번 사용할 수 있다 해서 별도의 사용 시간 변수를 둘 필요 없음
- 들어온 시간 + 나간 시간으로 사용 시간 계산

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=149854
 */