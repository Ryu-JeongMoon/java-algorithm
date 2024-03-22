package algorithm.programmers.level1;

/**
 * 숫자 짝꿍
 */
public class _131128 {

  public static void main(String[] args) {
    _131128 instance = new _131128();
    System.out.println(instance.solution("100", "2345"));
    System.out.println(instance.solution("100", "203045"));
    System.out.println(instance.solution("100", "123450"));
    System.out.println(instance.solution("12321", "42531"));
    System.out.println(instance.solution("5525", "1255"));
  }

  public String solution(String X, String Y) {
    int[][] theNumberOfDigits = new int[3][10];
    for (int i = 0; i < X.length(); i++) {
      ++theNumberOfDigits[0][X.charAt(i) - '0'];
    }

    for (int i = 0; i < Y.length(); i++) {
      ++theNumberOfDigits[1][Y.charAt(i) - '0'];
    }

    for (int i = 0; i < theNumberOfDigits[0].length; i++) {
      theNumberOfDigits[2][i] = Math.min(theNumberOfDigits[0][i], theNumberOfDigits[1][i]);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = theNumberOfDigits[0].length - 1; i >= 0; i--) {
      while (theNumberOfDigits[2][i]-- != 0) {
        sb.append(i);
      }
    }

    if (sb.isEmpty()) {
      return "-1";
    }

    String result = sb.toString();
    return result.startsWith("0") ? "0" : result;
  }
}

/*
time complexity
O(N)

critical point
0으로 시작하는 경우 고려

reference
https://school.programmers.co.kr/learn/courses/30/lessons/131128
*/
