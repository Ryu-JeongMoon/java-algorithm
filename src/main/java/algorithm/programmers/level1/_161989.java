package algorithm.programmers.level1;

/**
 * 덧칠하기
 */
public class _161989 {

  public static void main(String[] args) {
    _161989 instance = new _161989();
    System.out.println(instance.solution(8, 4, new int[] { 2, 3, 6 }));
    System.out.println(instance.solution(5, 4, new int[] { 1, 3 }));
    System.out.println(instance.solution(4, 1, new int[] { 1, 2, 3, 4 }));
    System.out.println(instance.solution(5, 5, new int[] { 3 }));
    System.out.println(instance.solution(4, 2, new int[] { 3, 4 }));
    System.out.println(instance.solution(5, 2, new int[] { 1, 4, 5 }));
  }

  public int solution(int n, int m, int[] section) {
    int index = 0, count = 0;
    for (int i : section) {
      if (index <= i) {
        index = i + m;
        ++count;
      }
    }
    return count;
  }
}

/*
time complexity
O(N)

critical point
다음번 칠할 벽을 만났을 때 인덱스 재할당 필요

reference
https://school.programmers.co.kr/learn/courses/30/lessons/161989
*/
