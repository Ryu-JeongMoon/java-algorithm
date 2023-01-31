package algorithm.programmers.level1;

public class HarshadNumber {

  public static void main(String[] args) {
    System.out.println(solution(11));

  }

  public static boolean solution(int x) {
    int sum = 0;
    int y = x;

    while (y > 0) {
      sum += y % 10;
      y /= 10;
    }

    return x % sum == 0;
  }
}
