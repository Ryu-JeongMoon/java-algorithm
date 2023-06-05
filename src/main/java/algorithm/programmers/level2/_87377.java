package algorithm.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 교점에 별 만들기
 */
public class _87377 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(new int[][]{ { 2, -1, 4 }, { -2, -1, 4 }, { 0, -1, 1 }, { 5, -8, -12 }, { 5, 8, 12 } })));
    System.out.println(Arrays.toString(solution(new int[][]{ { 0, 1, -1 }, { 1, 0, -1 }, { 1, 0, 1 } })));
    System.out.println(Arrays.toString(solution(new int[][]{ { 1, -1, 0 }, { 2, -1, 0 } })));
    System.out.println(Arrays.toString(solution(new int[][]{ { 1, -1, 0 }, { 2, -1, 0 }, { 4, -1, 0 } })));
  }

  public static String[] solution(int[][] line) {
    ArrayList<long[]> intersections = new ArrayList<>();

    long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE, minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;
    for (int i = 0; i < line.length - 1; i++) {
      long a = line[i][0], b = line[i][1], e = line[i][2];
      for (int j = i + 1; j < line.length; j++) {
        long c = line[j][0], d = line[j][1], f = line[j][2];
        if (a * d == b * c) {
          continue;
        }

        double x = (b * f - e * d) / (double) (a * d - b * c);
        double y = (e * c - a * f) / (double) (a * d - b * c);
        if (Math.floor(x) == x && Math.floor(y) == y) {
          intersections.add(new long[]{ (long) x, (long) y });
          minX = Math.min(minX, (long) x);
          maxX = Math.max(maxX, (long) x);
          minY = Math.min(minY, (long) y);
          maxY = Math.max(maxY, (long) y);
        }
      }
    }

    char[][] map = new char[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];
    for (char[] chars : map) {
      Arrays.fill(chars, '.');
    }

    for (long[] intersection : intersections) {
      map[(int) Math.abs(maxY - intersection[1])][(int) Math.abs(minX - intersection[0])] = '*';
    }

    String[] answer = new String[map.length];
    for (int i = 0; i < map.length; i++) {
      answer[i] = new String(map[i]);
    }
    return answer;
  }
}

/*
time complexity
O(n^2)

critical point
map[(int) Math.abs(maxY - intersection[1])][(int) Math.abs(intersection[0] - minX)] = '*';
좌표평면을 배열로 어떻게 조정하는가에 관한 문제
좌표평면의 y축 가장 높은 값을 0으로 옮겨야하기 때문에 maxY - y
좌표평면의 x축 가장 낮은 값을 0으로 옮겨야하기 때문에 minX - x

if (a * d == b * c) 조건 체크에서 a*d, b*c가 int 범위를 넘어가는 경우가 있을 수 있으므로 long cast

reference
https://programmers.co.kr/learn/courses/30/lessons/87377
*/
