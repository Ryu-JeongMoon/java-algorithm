package algorithm.programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumRectangle {

  public static void main(String[] args) {
    int[][] sizes = new int[][]{ { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };
    System.out.println(solution(sizes));

    int[][] sizes2 = new int[][]{ { 10, 7 }, { 12, 3 }, { 8, 15 }, { 14, 7 }, { 5, 15 } };
    System.out.println(solution(sizes2));
  }

  static int solution(int[][] sizes) {
    Integer maxCriteriaValue = Arrays.stream(sizes)
      .map(size -> Math.max(size[0], size[1]))
      .max(Comparator.naturalOrder())
      .orElseGet(() -> 0);

    Integer maxOfMinValues = Arrays.stream(sizes)
      .map(size -> Math.min(size[0], size[1]))
      .max(Comparator.naturalOrder())
      .orElseGet(() -> 0);

    return maxCriteriaValue * maxOfMinValues;
  }
}
