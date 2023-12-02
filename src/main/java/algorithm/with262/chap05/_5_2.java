package algorithm.with262.chap05;

import java.util.Arrays;

/**
 * 임의의 정수값 증가시키기
 */
public class _5_2 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(increase(new int[] { 1, 2, 3, 4, 5 })));
    System.out.println(Arrays.toString(increase(new int[] { 8, 9, 9, 9, 9 })));
    System.out.println(Arrays.toString(increase(new int[] { 9, 9, 9, 9, 9 })));
  }

  private static int[] increase(int[] input) {
    boolean carried = input[input.length - 1] == 9;
    input[input.length - 1] = (input[input.length - 1] + 1) % 10;
    for (int i = input.length - 2; i >= 0; i--) {
      if (carried) {
        if (input[i] != 9) {
          carried = false;
        }
        input[i] = (input[i] + 1) % 10;
      } else {
        break;
      }
    }

    if (input[0] == 0) {
      input = Arrays.copyOf(input, input.length + 1);
      input[0] = 1;
    }
    return input;
  }
}

/*
time complexity
O(n)

critical point
올림 처리

reference
5.2 임의의 정수값 증가시키기
*/
