package algorithm.forjava.chap05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaximumWindow {

  public static void main(String[] args) {
    int[] array = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
    System.out.println(Arrays.toString(maximum(array, 3)));
  }

  private static int[] maximum(int[] array, int windowSize) {
    Map<Integer, int[]> sumMap = new HashMap<>();

    for (int i = 0; i <= array.length - windowSize; i++) {
      int[] window = new int[windowSize];
      System.arraycopy(array, i, window, 0, windowSize);

      int sum = 0;
      for (int j = 0; j < windowSize; j++) {
        sum += window[j];
      }

      sumMap.put(sum, window);
    }

    Integer maxValue = sumMap.keySet()
      .stream()
      .max(Comparator.naturalOrder())
      .orElseThrow(IllegalArgumentException::new);

    return sumMap.get(maxValue);
  }
}
