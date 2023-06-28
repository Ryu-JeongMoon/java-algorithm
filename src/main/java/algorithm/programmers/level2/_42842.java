package algorithm.programmers.level2;

import java.util.Arrays;

/**
 * 카펫
 */
public class _42842 {

  public static void main(String[] args) {
    _42842 instance = new _42842();
    System.out.println(Arrays.toString(instance.solution(10, 2)));
    System.out.println(Arrays.toString(instance.solution(8, 1)));
    System.out.println(Arrays.toString(instance.solution(24, 24)));
  }

  public int[] solution(int brown, int yellow) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    int maxLoop = yellow % 2 == 0 ? yellow / 2 : yellow / 2 + 1;
    for (int i = 1; i <= maxLoop; i++) {
      if (yellow % i == 0) {
        int share = yellow / i;
        max = Math.max(share, i);
        min = Math.min(share, i);

        if (2 * max + 2 * min + 4 == brown) {
          return new int[] { max + 2, min + 2 };
        }
      }
    }

    return new int[] { max, min };
  }
}

/*
time complexity
n = yellow.length
O(n)

critical point
테두리는 오직 한줄
테두리 = 중앙 가로 * 2 + 중앙 세로 * 2 + 4

reference
https://programmers.co.kr/learn/courses/30/lessons/42842
*/
