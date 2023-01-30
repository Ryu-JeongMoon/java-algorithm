package algorithm.with262.chap04;

/**
 * 4.2 비트 스왑
 */
public class _4_2 {

  public static void main(String[] args) {
    System.out.println("swap(73, 6, 1) = " + swap(73, 6, 1));

    System.out.println("(1L << 1) = " + (1L << 1));

    long x = 323535L;
    System.out.println("(x ^ 3) = " + (x ^ 3));
    System.out.println("(x ^= 3) = " + (x ^= 3));
  }

  static long swap(long x, int i, int n) {
    if (((x >>> i) & 1) != ((x >>> n) & 1)) {
      long bitmask = (1L << i) | (1L << n);
      x ^= bitmask;
    }
    return x;
  }
}

/*
if (((x >>> i) & 1) != ((x >>> n) & 1))
swap 때릴 값이 같은 경우에는 바꿀 필요가 없으니 조건 검사

long bitmask = (1L << i) | (1L << n)
1L << i = 1L * 2의 i승
1L << n = 1L * 2의 n승
얘네 둘을 | 합해버림

합한 값을 bitmask 할당하고
x ^= bitmask 때리면 기존 값과 달라져야 하는 두 비트가 선택된 것?!
XOR 연산 수행해 기존이랑 비트를 바꿔준다
 */
