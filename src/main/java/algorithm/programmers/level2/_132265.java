package algorithm.programmers.level2;

import java.util.HashMap;
import java.util.Map;

/**
 * 롤케이크 자르기
 */
public class _132265 {

  public static void main(String[] args) {
    _132265 instance = new _132265();
    System.out.println(instance.solution(new int[] { 1, 2, 1, 3, 1, 4, 1, 2 }));
    System.out.println(instance.solution(new int[] { 1, 2, 3, 1, 4 }));
  }

  public int solution(int[] topping) {
    Map<Integer, Integer> older = new HashMap<>(), younger = new HashMap<>();
    for (int t : topping) {
      older.put(t, older.getOrDefault(t, 0) + 1);
    }

    int answer = 0;
    for (int i = 0; i < topping.length - 1; i++) {
      int current = topping[i];
      younger.put(current, younger.getOrDefault(current, 0) + 1);
      int quantity = older.get(current);
      if (quantity == 1) {
        older.remove(current);
      } else {
        older.put(current, quantity - 1);
      }

      if (older.size() == younger.size()) {
        ++answer;
      }
    }
    return answer;
  }
}

/*
time complexity
O(N)

critical point
공평하게 자르는 방법이 여러개일 수 있음
토핑의 개수까지 고려해야 하므로 Set 사용 불가능

reference
https://school.programmers.co.kr/learn/courses/30/lessons/132265
*/
