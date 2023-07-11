package algorithm.programmers.level0;

/**
 * 평행
 */
public class _120875 {

  public static void main(String[] args) {
    _120875 instance = new _120875();
    System.out.println(instance.solution(new int[][] { { 1, 4 }, { 9, 2 }, { 3, 8 }, { 11, 6 } }));
    System.out.println(instance.solution(new int[][] { { 3, 5 }, { 4, 1 }, { 2, 4 }, { 5, 10 } }));
  }

  public int solution(int[][] dots) {
    return (getSlope(dots[0], dots[1]) == getSlope(dots[2], dots[3])
      || getSlope(dots[0], dots[2]) == getSlope(dots[1], dots[3]))
      || getSlope(dots[0], dots[3]) == getSlope(dots[1], dots[2]) ? 1 : 0;
  }

  private double getSlope(int[] d1, int[] d2) {
    return (double) (d2[1] - d1[1]) / (d2[0] - d1[0]);
  }
}

/*
time complexity
O(1)

critical point
1. 두 점이 주어질 때 기울기 판단
2. HashSet<Double>은

reference
https://programmers.co.kr/learn/courses/30/lessons/120875
*/
