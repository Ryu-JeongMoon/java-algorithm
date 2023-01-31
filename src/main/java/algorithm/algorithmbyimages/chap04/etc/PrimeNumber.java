package algorithm.algorithmbyimages.chap04.etc;

import java.util.stream.IntStream;

public class PrimeNumber {

  public static void main(String[] args) {
    long startTime = System.nanoTime();
    System.out.println(isPrimeNumberWithStream(571));
    long endTime = System.nanoTime();
    System.out.println("time = " + (endTime - startTime) + "ns");

    startTime = System.nanoTime();
    System.out.println(isPrimeNumberWithForLoop(571));
    endTime = System.nanoTime();
    System.out.println("time = " + (endTime - startTime) + "ns");
  }

  // 오마이갓 스트림 쓰니까 100배 느림
  private static boolean isPrimeNumberWithStream(int n) {
    return IntStream.range(2, (int) (Math.sqrt(n) + 1))
      .filter(number -> n % number == 0)
      .findAny()
      .isEmpty();
  }

  private static boolean isPrimeNumberWithForLoop(int n) {
    for (int i = 2; i < (int) (Math.sqrt(n) + 1); i++) {
      if (n % i == 0)
        return false;
    }
    return true;
  }
}
