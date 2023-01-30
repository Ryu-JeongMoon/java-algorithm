package algorithm.leetcode.easy;

/**
 * 69. Sqrt(x)
 */
public class _69 {

  public static void main(String[] args) {
    System.out.println(mySqrt(2147395600));
    System.out.println(mySqrt(0x7fffffff - 1));
  }

  public static int mySqrt(int x) {
    if (x == 0) {
      return 0;
    }

    int start = 1, end = x;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
        return mid;
      } else if (mid > x / mid) {
        end = mid;
      } else {
        start = mid;
      }
    }
    return start;
  }
}

/*
time complexity
반토막씩 잘라가므로 O(log(n)), n은 최대 2^31-1이므로 O(31) -> O(1)

critical point
integer overflow 피하기 위한 i*i > x -> i > x/i

https://leetcode.com/problems/sqrtx/discuss/25198/3-JAVA-solutions-with-explanation
 */