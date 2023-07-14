package algorithm.programmers.level1;

/**
 * 없는 숫자 더하기
 */
public class _86051 {

  public static void main(String[] args) {
    _86051 instance = new _86051();
    System.out.println(instance.solution(new int[] { 1, 2, 3, 4, 6, 7, 8, 0 }));
    System.out.println(instance.solution(new int[] { 5, 8, 4, 0, 6, 7, 9 }));
  }

  public int solution(int[] numbers) {
    boolean[] visited = new boolean[10];
    for (int number : numbers) {
      visited[number] = true;
    }
    int sum = 0;
    for (int i = 1; i < visited.length; i++) {
      if (!visited[i]) {
        sum += i;
      }
    }
    return sum;
  }
}

/*
time complexity
O(N)

critical point

reference
https://programmers.co.kr/learn/courses/30/lessons/86051
*/
