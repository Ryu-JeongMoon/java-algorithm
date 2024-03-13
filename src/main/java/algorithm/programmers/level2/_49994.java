package algorithm.programmers.level2;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 방문 길이
 */
public class _49994 {

  public static void main(String[] args) {
    _49994 instance = new _49994();
    System.out.println(instance.solution("ULURRDLLU"));
    System.out.println(instance.solution("LULLLLLLU"));
    System.out.println(instance.solution("UDLRDURL"));
  }

  public int solution(String dirs) {
    Map<Character, int[]> direction = Map.of(
      'U', new int[] { -1, 0 },
      'D', new int[] { 1, 0 },
      'L', new int[] { 0, -1 },
      'R', new int[] { 0, 1 }
    );

    int[] current = new int[] { 5, 5 };

    Set<String> paths = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < dirs.length(); i++) {
      int[] toBeAdded = direction.get(dirs.charAt(i));

      if (isInMap(current[0] + toBeAdded[0], current[1] + toBeAdded[1])) {
        sb.append(current[0]).append(current[1]).append(current[0] + toBeAdded[0]).append(current[1] + toBeAdded[1]);
        paths.add(sb.toString());
        sb.setLength(0);
        sb.append(current[0] + toBeAdded[0]).append(current[1] + toBeAdded[1]).append(current[0]).append(current[1]);
        paths.add(sb.toString());
        sb.setLength(0);

        current[0] += toBeAdded[0];
        current[1] += toBeAdded[1];
      }
    }

    return paths.size() / 2;
  }

  private boolean isInMap(int row, int col) {
    return row >= 0 && row <= 10 && col >= 0 && col <= 10;
  }
}

/*
time complexity
O(N)

critical point
U (5,5) -> (4,5)
D (4,5) -> (5,5)
동일 경로 처리해야 하므로 양방향으로 Set 에 넣고 size / 2 반환

reference
https://school.programmers.co.kr/learn/courses/30/lessons/49994
*/
