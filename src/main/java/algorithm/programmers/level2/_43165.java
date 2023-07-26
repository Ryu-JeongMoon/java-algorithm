package algorithm.programmers.level2;

/**
 * 타겟 넘버
 */
public class _43165 {

  public static void main(String[] args) {
    _43165 instance = new _43165();
    System.out.println(instance.solution(new int[] { 1, 1, 1 }, 1));
    System.out.println(instance.solution(new int[] { 1, 1, 1, 1, 1 }, 3));
    System.out.println(instance.solution(new int[] { 4, 1, 2, 1 }, 4));
  }

  public int solution(int[] numbers, int target) {
    return dfs(numbers, target, 0, 0);
  }

  private int dfs(int[] numbers, int target, int index, int sum) {
    if (index == numbers.length) {
      return sum == target ? 1 : 0;
    }

    return dfs(numbers, target, index + 1, sum + numbers[index])
      + dfs(numbers, target, index + 1, sum - numbers[index]);
  }
}

/*
time complexity
O(2^N)

critical point
재귀 함수의 이해

reference
https://programmers.co.kr/learn/courses/30/lessons/43165
*/
