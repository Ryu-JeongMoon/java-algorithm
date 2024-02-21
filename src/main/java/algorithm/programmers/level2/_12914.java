package algorithm.programmers.level2;

/**
 * 멀리 뛰기
 */
public class _12914 {

  public static void main(String[] args) {
    _12914 instance = new _12914();
    System.out.println(instance.solution(1));
    System.out.println(instance.solution(2));
    System.out.println(instance.solution(3));
    System.out.println(instance.solution(4));
    System.out.println(instance.solution(2000));
  }

  public int solution(int n) {
    int[] values = new int[n + 1];
    values[0] = values[1] = 1;
    for (int i = 2; i < n + 1; i++) {
      values[i] = (values[i - 1] + values[i - 2]) % 1234567;
    }
    return values[n];
  }
}

/*
time complexity
O(N)

critical point
최대 2000까지의 경우에도 int overflow 발생하지 않음, long 반환 필요 없음

reference
https://school.programmers.co.kr/learn/courses/30/lessons/12914
*/
