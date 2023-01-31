package algorithm.programmers.level1;

public class AddCiphers {

  public static void main(String[] args) {
    System.out.println(solution(123));
  }

  public static int solution(int n) {
    int answer = 0;

    while (n > 0) {
      int eachCipher = n % 10;
      answer += eachCipher;
      n /= 10;
    }
    return answer;
  }
}
