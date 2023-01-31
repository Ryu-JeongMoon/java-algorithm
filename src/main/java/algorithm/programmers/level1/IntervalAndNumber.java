package algorithm.programmers.level1;

public class IntervalAndNumber {

  public static void main(String[] args) {
    System.out.println(solution(4, 3));
  }

  public static long[] solution(int x, int n) {
    long[] answer = new long[n];
    for (int i = 0; i < n; i++) {
      answer[i] = (long) x * (i + 1);
    }
    return answer;
  }
}
