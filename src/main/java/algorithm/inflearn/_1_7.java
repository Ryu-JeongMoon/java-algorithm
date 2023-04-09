package algorithm.inflearn;

/**
 * 비밀번호
 */
public class _1_7 {

  private static final double ONE_SECOND_THRESHOLD = 3;

  public static void main(String[] args) {
    System.out.println(solution(new int[]{ 2, 5, 3, 7, 1, 6, 4, 9, 8 }, "7596218"));
    System.out.println(solution(new int[]{ 1, 5, 7, 3, 2, 8, 9, 4, 6 }, "63855526592"));
    System.out.println(solution(new int[]{ 2, 9, 3, 7, 8, 6, 4, 5, 1 }, "323254677"));
    System.out.println(solution(new int[]{ 1, 6, 7, 3, 8, 9, 4, 5, 2 }, "3337772122"));
  }

  public static int solution(int[] keypad, String password) {
    Point[] points = new Point[keypad.length + 1];
    for (int i = 0; i < keypad.length; i++) {
      points[keypad[i]] = new Point(i / 3, i % 3);
    }

    int time = 0;
    char current = password.charAt(0);
    for (int i = 1; i < password.length(); i++) {
      char next = password.charAt(i);
      time += calculateTime(points, current, next);
      current = next;
    }
    return time;
  }

  private static int calculateTime(Point[] points, char current, char next) {
    if (current == next)
      return 0;

    return points[current - '0'].distance(points[next - '0']) < ONE_SECOND_THRESHOLD ? 1 : 2;
  }

  private record Point(int x, int y) {

    private double distance(Point other) {
      return Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2);
    }
  }
}

/*
time complexity
O(N)

critical point
대각선까지 1초이므로 두 좌표 (x1,y1), (x2,y2) 사이의 거리는 (x1-x2)^2 + (y1-y2)^2 < 3 이면 1초, 아니면 2초

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=149834
 */