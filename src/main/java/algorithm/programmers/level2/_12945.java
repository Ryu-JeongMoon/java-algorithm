package algorithm.programmers.level2;

/**
 * 피보나치 수
 */
public class _12945 {

  public static void main(String[] args) {
    _12945 instance = new _12945();
    System.out.println(instance.solution(2));
    System.out.println(instance.solution(3));
    System.out.println(instance.solution(5));
    System.out.println(instance.solution(10));
  }

  public int solution(int n) {
    // return recursiveFibonacci(n, new int[n + 1]);
    return iterativeFibonacci(n, new int[n + 1]);
  }

  private int recursiveFibonacci(int n, int[] memoization) {
    if (n == 0 || n == 1) {
      return n;
    }

    if (memoization[n] == 0) {
      memoization[n] = (recursiveFibonacci(n - 1, memoization) + recursiveFibonacci(n - 2, memoization)) % 1234567;
    }

    return memoization[n];
  }

  private int iterativeFibonacci(int n, int[] memoization) {
    if (n == 0 || n == 1) {
      return n;
    }

    memoization[0] = 0;
    memoization[1] = 1;
    for (int i = 2; i < n + 1; i++) {
      memoization[i] = (memoization[i - 1] + memoization[i - 2]) % 1234567;
    }

    return memoization[n];
  }
}

/*
recursive                                iterative
테스트 1  〉	통과 (0.04ms, 75.7MB)      테스트 1  〉	통과 (0.02ms, 72.3MB)
테스트 2  〉	통과 (0.03ms, 72.7MB)      테스트 2  〉	통과 (0.01ms, 72.9MB)
테스트 3  〉	통과 (0.04ms, 73.1MB)      테스트 3  〉	통과 (0.02ms, 78.1MB)
테스트 4  〉	통과 (0.02ms, 72.5MB)      테스트 4  〉	통과 (0.03ms, 72MB)
테스트 5  〉	통과 (0.02ms, 73.7MB)      테스트 5  〉	통과 (0.03ms, 77.7MB)
테스트 6  〉	통과 (0.03ms, 72.6MB)      테스트 6  〉	통과 (0.02ms, 73.3MB)
테스트 7  〉	통과 (0.34ms, 73.8MB)      테스트 7  〉	통과 (0.07ms, 75.8MB)
테스트 8  〉	통과 (0.25ms, 75.5MB)      테스트 8  〉	통과 (0.04ms, 70.4MB)
테스트 9  〉	통과 (0.12ms, 74.1MB)      테스트 9  〉	통과 (0.05ms, 70.2MB)
테스트 10 〉	통과 (0.44ms, 71.3MB)      테스트 10 〉	통과 (0.12ms, 77.2MB)
테스트 11 〉	통과 (0.17ms, 83.3MB)      테스트 11 〉	통과 (0.03ms, 79.1MB)
테스트 12 〉	통과 (0.21ms, 73.5MB)      테스트 12 〉	통과 (0.05ms, 73.3MB)
테스트 13 〉	통과 (18.75ms, 90.8MB)     테스트 13 〉	통과 (3.97ms, 86.3MB)
테스트 14 〉	통과 (13.71ms, 83.8MB)     테스트 14 〉	통과 (2.47ms, 77.1MB)

time complexity
O(n)

critical point
iterative solution is faster than recursive solution

reference
https://programmers.co.kr/learn/courses/30/lessons/12945
*/
