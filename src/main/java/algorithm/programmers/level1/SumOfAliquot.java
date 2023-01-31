package algorithm.programmers.level1;

import java.util.stream.IntStream;

public class SumOfAliquot {

  public static void main(String[] args) {
    System.out.println(solution(5));
  }

  static int solution(int n) {
    return IntStream.rangeClosed(1, n / 2)
      .filter(i -> n % i == 0)
      .sum() + n;
  }
}
