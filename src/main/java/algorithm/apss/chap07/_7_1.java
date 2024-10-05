package algorithm.apss.chap07;

public class _7_1 {

  public static void main(String[] args) {
    System.out.println(recursiveSum(100000000));
  }

  // divide and conquer
  private static int recursiveSum(int n) {
    if (n == 0) {
      return 0;
    } else if (n % 2 == 1) {
      return recursiveSum(n - 1) + n;
    } else {
      return 2 * recursiveSum(n / 2) + (n / 2) * (n / 2);
    }
  }
}

/*
1 + 2 + 3 + ... + n 을 두 부분으로 나눔
(1 + 2 + 3 + ... + n/2) + ((n/2+1) + (n/2+2) + ... + n)
1. (1 + 2 + 3 + ... + n/2)
2. ((n/2+1) + (n/2+2) + ... + n)

두번째 부분인 ((n/2+1) + (n/2+2) + ... + (n/2+n/2))
고정 부분은 n/2가 n/2번 반복
가변 부분은 (1 + 2 + 3 + ... n/2)
*/
