package algorithm.programmers.level1;

public class revertTernaryScale {

  public static void main(String[] args) {
    System.out.println(solution(45));
    System.out.println(solution(2));
  }

  static int solution(int n) {
    StringBuilder sb = new StringBuilder();

    while (n > 0) {
      sb.append(n % 3);
      n /= 3;
    }

    return Integer.parseInt(sb.toString(), 3);
  }
}
