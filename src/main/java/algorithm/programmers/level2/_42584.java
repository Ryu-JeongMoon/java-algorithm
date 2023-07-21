package algorithm.programmers.level2;

import java.util.Arrays;

/**
 * 주식가격
 */
public class _42584 {

  public static void main(String[] args) {
    _42584 instance = new _42584();
    System.out.println(Arrays.toString(instance.solution(new int[] { 1, 5, 3, 10000 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 2, 2 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 4, 3, 2, 1 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 1, 2, 3, 2, 3 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 1, 2, 3, 2, 1 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 1, 2, 3, 4, 1 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 5, 4, 3, 2, 5 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 5, 4, 3, 2, 1 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 2, 2, 3, 1, 5 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 4, 2, 7, 6, 2 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 1, 2, 3, 2, 3, 1 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 1, 2, 3, 4, 5, 6, 1, 1, 2, 3, 1, 2, 3 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 1, 3, 5, 7, 9, 4, 5, 2, 1, 0 })));
  }

  public int[] solution(int[] prices) {
    int[] answer = new int[prices.length];
    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        ++answer[i];
        if (prices[i] > prices[j]) {
          break;
        }
      }
    }
    return answer;
  }
}

/*
time complexity
O(N^2)

critical point
뭐 이딴 문제가 다 있음

reference
https://programmers.co.kr/learn/courses/30/lessons/42584
*/
