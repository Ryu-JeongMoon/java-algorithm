package algorithm.programmers.level0;

/**
 * 저주의 숫자 3
 */
public class _120871 {

  public static void main(String[] args) {
    _120871 instance = new _120871();
    System.out.println(instance.solution(15));
    System.out.println(instance.solution(40));
  }

  public int solution(int n) {
    int[] memoization = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      int next = memoization[i - 1] + 1;
      while (next % 3 == 0 || containsThree(next)) {
        ++next;
      }
      memoization[i] = next;
    }
    return memoization[n];
  }

  private boolean containsThree(int n) {
    while (n > 0 && n % 10 != 3) {
      n /= 10;
    }
    return n % 10 == 3;
  }
}

/*
time complexity
O(n)

critical point

reference
https://programmers.co.kr/learn/courses/30/lessons/120871
*/
