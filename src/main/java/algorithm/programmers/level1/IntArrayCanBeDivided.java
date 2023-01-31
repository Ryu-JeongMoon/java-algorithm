package algorithm.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntArrayCanBeDivided {

  public static void main(String[] args) {
    int[] arr = { 2, 36, 1, 3 };
    int divisor = 1;
    System.out.println((Arrays.toString(solution(arr, divisor))));
  }

  public static int[] solution(int[] arr, int divisor) {
    List<Integer> integers = new ArrayList<>();
    for (int i : arr) {
      if (i % divisor == 0) {
        integers.add(i);
      }
    }
    Collections.sort(integers);

    if (integers.size() == 0) {
      return new int[] { -1 };
    }

    int[] ints = new int[integers.size()];
    for (int i = 0; i < integers.size(); i++) {
      ints[i] = integers.get(i);
    }

    return ints;
  }
}
