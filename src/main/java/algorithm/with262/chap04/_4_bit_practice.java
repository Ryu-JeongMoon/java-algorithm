package algorithm.with262.chap04;

public class _4_bit_practice {

  public static void main(String[] args) {
    System.out.println("(6 & 4) = " + (6 & 4));
    System.out.println("(1 | 2) = " + (1 | 2));
    System.out.println("(8 >> 1) = " + (8 >> 1));
    System.out.println("(8 >>> 1) = " + (8 >>> 1));
    System.out.println("(8 >>> 1) = " + (8 >>> 1));
    System.out.println("(1 << 10) = " + (1 << 10));
    System.out.println("(16 >> 2) = " + (16 >> 2));
    System.out.println("(15 ^ 3) = " + (15 ^ 3));
    System.out.println("Character.getNumericValue('a') = " + Character.getNumericValue('a'));
    System.out.println("('a' - '0') = " + ('a' - '0'));
  }
}

/*
<< N 연산자는 비트를 왼쪽으로 이동시킨다
2^N를 곱한다고 생각

>> N 연산자는 비트를 오른쪽으로 이동시킨다
2^N로 나눈 몫이라 생각

>>> 연산자는 부호를 신경쓰지 않는다
비트 값들을 오른쪽으로 이동시킨 후에 왼쪽의 빈 공간은 모두 0 으로 채운다.

^ 연산자는 비트를 XOR 연산한다
1111 ^ 11 = 1100 -> 12
 */
