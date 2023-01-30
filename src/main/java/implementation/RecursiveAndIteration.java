package implementation;

public class RecursiveAndIteration {

  private static final int[] ARRAY = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
  private static final int[] BIG_ARRAY = new int[5_000];

  static {
    for (int i = 0; i < BIG_ARRAY.length; i++) {
      BIG_ARRAY[i] = ARRAY[i % 10];
    }
  }

  public static void main(String[] args) {
    int result1 = getSumByTailRecursive(BIG_ARRAY);
    System.out.println("result1 = " + result1);

    int result2 = getSumByRecursive(BIG_ARRAY);
    System.out.println("result2 = " + result2);

    int result3 = getSumByIteration(BIG_ARRAY);
    System.out.println("result3 = " + result3);
  }

  // recursive
  private static int getSumByRecursive(int[] arr) {
    return getSumByRecursive(arr, arr.length - 1);
  }

  private static int getSumByRecursive(int[] arr, int index) {
    return index > 0 ? arr[index] + getSumByRecursive(arr, index - 1) : arr[0];
  }

  // tail recursive
  private static int getSumByTailRecursive(int[] arr) {
    return arr.length > 1 ? getSumByTailRecursive(arr, arr.length - 1, 0) : arr[0];
  }

  private static int getSumByTailRecursive(int[] arr, int index, int sum) {
    return index > -1 ? getSumByTailRecursive(arr, index - 1, sum + arr[index]) : sum;
  }

  private static int getSumByIteration(int[] arr) {
    int sum = 0;
    for (int i : arr) {
      sum += i;
    }
    return sum;
  }
}

/*
reference
https://softwareengineering.stackexchange.com/questions/272061/why-doesnt-java-have-optimization-for-tail-recursion-at-all

Java language and library architect Brian Goetz explains the historical reason why the JVM did not support tail recursion:
certain security-sensitive methods depended on counting stack frames
between JDK library code and calling code in order to figure out who was calling them.
TCO would have interfered with this.
He adds that this code has now been replaced and that support for tail recursion is on the backlog, albeit not very high priority.
 */