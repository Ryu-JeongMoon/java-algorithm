package algorithm.programmers.level1;

/**
 * 체육복
 */
public class _42862 {

  public static void main(String[] args) {
    _42862 instance = new _42862();
    System.out.println(instance.solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 }));
    System.out.println(instance.solution(5, new int[] { 2, 4 }, new int[] { 3 }));
    System.out.println(instance.solution(3, new int[] { 3 }, new int[] { 1 }));
  }

  public int solution(int n, int[] lost, int[] reserve) {
    int[] students = new int[n];
    for (int r : reserve) {
      ++students[r - 1];
    }
    for (int l : lost) {
      --students[l - 1];
    }
    for (int i = 0; i < students.length; i++) {
      if (students[i] == -1) {
        if (i > 0 && students[i - 1] > 0) {
          ++students[i];
          --students[i - 1];
        } else if (i + 1 < students.length && students[i + 1] > 0) {
          ++students[i];
          --students[i + 1];
        } else {
          --n;
        }
      }
    }
    return n;
  }
}

/*
time complexity
O(N)

critical point
기준 값을 바꿔 연산 횟수 줄이기
체육복 하나만 가지고 있는 경우를 1 -> 0로 생각
Arrays.fill(array, 1) 할 필요가 없어짐

reference
https://programmers.co.kr/learn/courses/30/lessons/42862
*/
