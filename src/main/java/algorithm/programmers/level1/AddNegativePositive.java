package algorithm.programmers.level1;

import java.util.stream.IntStream;

public class AddNegativePositive {

  public static void main(String[] args) {

    int[] absolutes = { 4, 7, 12 };
    boolean[] signs = { true, false, true };

    long start1 = System.nanoTime();
    System.out.println(solution(absolutes, signs));
    long finish1 = System.nanoTime();

    long start2 = System.nanoTime();
    System.out.println(solution2(absolutes, signs));
    long finish2 = System.nanoTime();

    System.out.println("(finish1-start1) = " + (finish1 - start1));
    System.out.println("(finish2-start2) = " + (finish2 - start2));
  }

  static int solution(int[] absolutes, boolean[] signs) {
    int answer = 0;

    for (int i = 0; i < absolutes.length; i++) {
      if (!signs[i]) {
        absolutes[i] = -absolutes[i];
      }
      answer += absolutes[i];
    }
    return answer;
  }

  // 개느려..
  static int solution2(int[] absolutes, boolean[] signs) {
    return IntStream.range(0, absolutes.length)
      .parallel()
      .map(i -> signs[i] ? absolutes[i] : -absolutes[i])
      .sum();
  }
}
