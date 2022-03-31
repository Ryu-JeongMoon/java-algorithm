package algorithm.with262.chap04;

import algorithm.with262.TimeUtils;

/**
 * 4.1 패리티 계산하기
 */
public class _4_1 {

  public static void main(String[] args) {
    TimeUtils.printElapsedTime(() -> parityWithBruteForce(15935L));

    TimeUtils.printElapsedTime(() -> parityWithTrick(15935L));

    TimeUtils.printElapsedTime(() -> parityWithMask(15935L));
  }

  /*
  전체를 순회하며 최하위 비트 값만 확인해간다
  최하위 비트가 1인 경우에만 result 값이 변화한다
  전체 비트 중 1의 개수가
  홀수인 경우 result -> 홀수, 짝수면 result -> 짝수
   */
  static short parityWithBruteForce(long x) {
    short result = 0;
    while (x != 0) {
      result ^= (x & 1);
      x >>>= 1;
    }
    return result;
  }

  /*
  1의 개수만 확인하면 되니 전체를 돌 필요가 없다는 점에서 착안
  x가 0이 아닐 때까지 돌되 x의 다음 값을 x &= (x-1)로 1 비트 중 가장 작은 값을 0으로 만든다
  4를 예시로 보면 0110 & 0101 -> 0100
  요렇게 계속 돌면서 1인 비트만 없애나간다
   */
  static short parityWithTrick(long x) {
    short result = 0;
    while (x != 0) {
      result ^= 1;
      x &= (x - 1);
    }
    return result;
  }

  static short parityWithMask(long x) {
    final int WORD_SIZE = 16;
    final int BIT_MASK = 0xFFFF;
    final int[] preComputedParity = { 0, 1, 1, 0 };

    return (short) (
      preComputedParity[(int) ((x >>> (3 * WORD_SIZE)) & BIT_MASK)] ^
        preComputedParity[(int) ((x >>> (2 * WORD_SIZE)) & BIT_MASK)] ^
        preComputedParity[(int) ((x >>> WORD_SIZE) & BIT_MASK)] ^
        preComputedParity[(int) (x & BIT_MASK)]
    );
  }
}

/*
parity ?
데이터 전달 과정에서 이상이 생겼는지 검사하기 위해 전체 비트의 개수를 2로 나눈 나머지 값이다
1110 -> 홀수 (1)
1010 -> 짝수 (0)
 */