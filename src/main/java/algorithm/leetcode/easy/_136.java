package algorithm.leetcode.easy;

/**
 * 136. Single Number
 */
public class _136 {

  public static int[] visited;

  public static void main(String[] args) {
    int[] nums1 = { 4, 1, 2, 1, 2 };
    System.out.println(singleNumber2(nums1));

    int[] nums2 = { 2, 2, 1 };
    System.out.println(singleNumber2(nums2));
  }

  // 16 ms  54.5 MB
  public static int singleNumber(int[] nums) {
    visited = new int[60001];
    for (int num : nums) {
      visited[30000 + num]++;
    }

    for (int i = 30000; i < visited.length; i++) {
      if (visited[i] == 1) {
        return i - 30000;
      }
    }

    for (int i = 0; i < visited.length / 2; i++) {
      if (visited[i] == 1) {
        return i - 30000;
      }
    }
    return 0;
  }

  // 	6 ms	50.5 MB
  public static int singleNumber2(int[] nums) {
    int result = 0;
    for(int i : nums) {
      result ^= i;
    }
    return result;
  }
}

/*
time complexity
O(n)

critical point
문제 설명에서 친절하게도
1. 하나의 요소를 제외하면 두번씩 나타난다고 했고
2. 공간 복잡도는 상수가 되도록 사용하라고 했다

XOR 개념을 사용하면 훨씬 쉽게 풀 수 있다
0과 찾으려는 수를 제외하면 나머지 수들은 짝수로 (여기서는 2) 나타난다
이 수들은 전부 XOR 연산에서 0으로 취급되므로 결국 X ^ 0 = X가 된다
 */