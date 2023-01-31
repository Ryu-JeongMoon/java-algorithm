package algorithm.programmers.level1;

import java.util.stream.LongStream;

public class SumOfBetweenTwoInteger {

  public static void main(String[] args) {
    System.out.println(solution(3, 5));
  }

  public static long solution(int a, int b) {
    return LongStream.rangeClosed(Math.min(a, b), Math.max(a, b))
      .sum();
  }
}
