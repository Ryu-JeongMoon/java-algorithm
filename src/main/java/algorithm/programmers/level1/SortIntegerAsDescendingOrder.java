package algorithm.programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class SortIntegerAsDescendingOrder {

  public static void main(String[] args) {
    System.out.println(solution(118372));
  }

  public static long solution(long number) {
    return Long.parseLong(Arrays.stream(String.valueOf(number).split(""))
      .sorted(Comparator.reverseOrder())
      .reduce(String::concat)
      .orElseGet(() -> ""));
  }
}
