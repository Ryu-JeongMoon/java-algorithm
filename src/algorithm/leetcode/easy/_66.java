package algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * 66. Plus One
 */
public class _66 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(plusOne(new int[]{ 1, 2, 3 })));
    System.out.println(Arrays.toString(plusOne(new int[]{ 4, 3, 2, 1 })));
    System.out.println(Arrays.toString(plusOne(new int[]{ 9 })));
    System.out.println(Arrays.toString(plusOne(new int[]{ 9, 9 })));
    System.out.println(Arrays.toString(plusOne(new int[]{ 9, 9, 9 })));
  }

  public static int[] plusOne(int[] digits) {
    if (digits[digits.length - 1] != 9) {
      digits[digits.length - 1]++;
      return digits;
    }

    return carry(digits, digits.length - 1);
  }

  public static int[] carry(int[] digits, int index) {
    if (digits[index] != 9) {
      digits[index]++;
      return digits;
    }

    if (index != 0) {
      digits[index] = 0;
      return carry(digits, index - 1);
    }

    int[] result = new int[digits.length + 1];
    result[0] = 1;
    System.arraycopy(digits, 0, result, 1, digits.length);
    result[1] = 0;
    return result;
  }
}

/*
time complexity
입력 값이 9의 연속으로 오는 경우,
맨 뒷자리부터 맨 앞자리까지 순회해야 하므로 O(n)

critical point
뒤에서부터 9가 아닌 숫자를 만나면 1을 더하고 리턴
9를 만나면 0으로 바꾸고 앞으로 이동

재귀로 풀었는데 반복으로 쉽게 푸는 방법이 있다?!
재귀로 풀어가지고 메모리 사용이 높게 나온 듯
반복으로 풀어보기

9 -> 1, 0
9, 9 -> 1, 0, 0
9, 9, 9, 9 -> 1, 0, 0, 0, 0
 */