package algorithm.with262;

import java.util.function.Supplier;

public class TimeUtils {

  private TimeUtils() {
  }

  public static <T> void printElapsedTime(Supplier<T> supplier) {
    long start = System.nanoTime();
    System.out.println("result => " + supplier.get());
    System.out.println("time   => " + (System.nanoTime() - start));
    System.out.println();
  }
}
