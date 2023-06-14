package algorithm.programmers.level1;

/**
 * 3진법 뒤집기
 */
public class _68935 {

  public static void main(String[] args) {
    _68935 instance = new _68935();
    System.out.println(instance.solution1(45));
    System.out.println(instance.solution2(45));

    System.out.println(instance.solution1(125));
    System.out.println(instance.solution2(125));
  }

  public long solution1(long n) {
    int index = 0, length = 0;
    long temp = n;
    while (temp > 0) {
      ++length;
      temp /= 3;
    }

    long result = 0;
    while (n > 0) {
      result += (n % 3) * Math.pow(3, length - index++ - 1);
      n /= 3;
    }
    return result;
  }

  public long solution2(long n) {
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      sb.append(n % 3);
      n /= 3;
    }
    return Integer.parseInt(sb.toString(), 3);
  }
}

/*
time complexity
O(logN)

critical point
Integer.parseInt(string-value, radix) 활용
radix -> 진법 지정하여 변환 가능

reference
https://programmers.co.kr/learn/courses/30/lessons/68935
*/
