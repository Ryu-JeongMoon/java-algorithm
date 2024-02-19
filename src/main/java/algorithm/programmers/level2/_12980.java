package algorithm.programmers.level2;

/**
 * 점프와 순간이동
 */
public class _12980 {

  public static void main(String[] args) {
    _12980 instance = new _12980();
    System.out.println(instance.solution(5));
    System.out.println(instance.solution(6));
    System.out.println(instance.solution(5000));
  }

  public int solution(int n) {
    int count = 0;
    while (n > 0) {
      if (n % 2 != 0) {
        n -= 1;
        ++count;
      }
      n /= 2;
    }
    return count;
  }
}

/*
time complexity
O(logN)

critical point
목적지로부터 역으로 계산
절반으로 나눠지는 경우 순간이동, 아닌 경우 1을 점프하고 순간이동으로 판단

reference
https://school.programmers.co.kr/learn/courses/30/lessons/12980
*/
