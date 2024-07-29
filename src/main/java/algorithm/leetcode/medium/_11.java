package algorithm.leetcode.medium;

/**
 * Container With Most Water
 */
public class _11 {

  public static void main(String[] args) {
    _11 instance = new _11();

    System.out.println(instance.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    System.out.println(instance.maxArea(new int[] { 1, 1 }));
  }

  public int maxArea(int[] height) {
    int max = 0, left = 0, right = height.length - 1;
    while (left < right) {
      max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
      if (height[left] < height[right]) {
        ++left;
      } else if (height[left] > height[right]) {
        --right;
      } else {
        ++left;
        --right;
      }
    }
    return max;
  }
}

/*
time complexity
O(N)

critical point
5ms, Beats 68.88%
2중 for-loop -> O(n^2), n <= 10^5 이므로 최대 10^10 시간초과 가능성 있음
two pointer 사용하여 O(N)으로 해결

reference
https://leetcode.com/problems/container-with-most-water/
*/
