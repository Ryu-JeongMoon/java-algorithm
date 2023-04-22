package algorithm.inflearn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 문서 도난
 */
public class _2_6 {

  public static void main(String[] args) {
    String[] x1 = sol(new String[]{ "john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57" }, "08:33 09:45");
    String[] x2 = sol(new String[]{ "ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59" },
      "15:01 19:59");
    String[] x3 = sol(new String[]{ "cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50" }, "14:20 15:20");

    System.out.println(Arrays.toString(x1));
    System.out.println(Arrays.toString(x2));
    System.out.println(Arrays.toString(x3));
  }

  public static String[] sol(String[] reports, String times) {
    String[] range = times.split(" ");
    int startTime = getTimeInMinutes(range[0].split(":"));
    int endTime = getTimeInMinutes(range[1].split(":"));

    HashMap<String, Integer> usingTimeForPerson = new HashMap<>();
    for (String report : reports) {
      String[] s = report.split(" ");
      int timeInMinutes = getTimeInMinutes(s[1].split(":"));
      if (timeInMinutes < startTime || endTime < timeInMinutes) {
        continue;
      }
      usingTimeForPerson.put(s[0], timeInMinutes);
    }

    return usingTimeForPerson.keySet().stream()
      .sorted(Comparator.comparing(usingTimeForPerson::get))
      .toList()
      .toArray(new String[]{});
  }

  private static int getTimeInMinutes(String[] time) {
    return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
  }
}

/*
time complexity
O(NlogN)

critical point

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=149852
 */