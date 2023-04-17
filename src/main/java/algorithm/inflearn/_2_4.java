package algorithm.inflearn;

import java.util.HashMap;
import java.util.Map;

/**
 * 음수가 있는 부분 수열
 */
public class _2_4 {

  public static void main(String[] args) {
    System.out.println(solution(new int[]{ 2, 2, 3, -1, -1, -3, 3, -5, 1, 4 }, 5));
    System.out.println(solution(new int[]{ 2, 2, 3, -1, -1, -1, 3, 1, 1 }, 5));
    System.out.println(solution(new int[]{ 1, 2, 3, -3, 1, 2, 2, -3 }, 5));
    System.out.println(solution(new int[]{ 1, 2, 3, -3, 1, 2 }, 3));
    System.out.println(solution(new int[]{ -1, 0, 1 }, 0));
    System.out.println(solution(new int[]{ -1, -1, -1, 1 }, 0));
  }

  public static int solution(int[] nums, int m) {
    // index 0부터 i까지 더했을 때 sum == m인 경우를 위해 (0,1) entry 필요
    Map<Integer, Integer> numbers = new HashMap<>();
    numbers.put(0, 1);

    int answer = 0, sum = 0;
    for (int num : nums) {
      sum += num;
      if (numbers.containsKey(sum - m)) {
        answer += numbers.get(sum - m);
      }
      numbers.put(sum, numbers.getOrDefault(sum, 0) + 1);
    }
    return answer;
  }
}

/*
time complexity
O(N)

critical point
음수 값이 올 수 있으므로 계속 증가한다는 전제가 없음, two pointer 사용 불가
이전 값들의 합을 해싱하므로써 현재 값까지의 합 - 이전 값까지의 합으로 중간 부분의 수열을 구할 수 있음

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=149848
 */