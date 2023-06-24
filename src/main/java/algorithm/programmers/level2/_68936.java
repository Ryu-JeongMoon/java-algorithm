package algorithm.programmers.level2;

import java.util.Arrays;

/**
 * 쿼드압축 후 개수 세기
 */
public class _68936 {

  private int one = 0, zero = 0;

  public static void main(String[] args) {
    _68936 instance = new _68936();

    System.out.println(Arrays.toString(instance.solution(new int[][] { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } })));
    System.out.println(Arrays.toString(
      instance.solution(new int[][] {
        { 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1 }, { 0, 1, 0, 0, 1, 1, 1, 1 },
        { 0, 0, 0, 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 1, 0, 0, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1 }
      })));
  }

  public int[] solution(int[][] arr) {
    return compress(arr, 0, 0, arr.length);
  }

  private int[] compress(int[][] arr, int startX, int startY, int ratio) {
    if (ratio == 2) {
      int sum = arr[startX][startY] + arr[startX + 1][startY] + arr[startX][startY + 1] + arr[startX + 1][startY + 1];
      return switch (sum) {
        case 0 -> new int[] { 1, 0 };
        case 4 -> new int[] { 0, 1 };
        default -> new int[] { 4 - sum, sum };
      };
    }

    ratio /= 2;
    int[] leftUpper = compress(arr, startX, startY, ratio);
    int[] leftLower = compress(arr, startX + ratio, startY, ratio);
    int[] rightUpper = compress(arr, startX, startY + ratio, ratio);
    int[] rightLower = compress(arr, startX + ratio, startY + ratio, ratio);

    int x = leftUpper[0] + leftLower[0] + rightUpper[0] + rightLower[0];
    int y = leftUpper[1] + leftLower[1] + rightUpper[1] + rightLower[1];
    return new int[] { x >= 4 && y == 0 ? x / 4 : x, y >= 4 && x == 0 ? y / 4 : y };
  }

  public int[] solution2(int[][] arr) {
    press(arr, 0, arr.length, 0, arr.length);
    return new int[] { zero, one };
  }

  private void press(int[][] arr, int xs, int xe, int ys, int ye) {
    int oneCnt = 0, max = (int) Math.pow(xe - xs, 2);
    for (int i = xs; i < xe; i++) {
      for (int j = ys; j < ye; j++) {
        oneCnt += arr[i][j];
      }
    }

    if (oneCnt == 0) {
      zero++;
    } else if (oneCnt == max) {
      one++;
    } else {
      int xm = (xe + xs) / 2;
      int ym = (ye + ys) / 2;
      press(arr, xs, xm, ys, ym);
      press(arr, xm, xe, ys, ym);
      press(arr, xs, xm, ym, ye);
      press(arr, xm, xe, ym, ye);
    }
  }
}

/*
              solution1               solution2
테스트 1  〉	통과 (0.08ms, 76.4MB)   통과 (0.43ms, 68.2MB)
테스트 2  〉	통과 (0.16ms, 74.2MB)   통과 (0.22ms, 79.1MB)
테스트 3  〉	통과 (0.08ms, 76MB)     통과 (0.13ms, 71.7MB)
테스트 4  〉	통과 (0.05ms, 74.1MB)   통과 (0.07ms, 79MB)
테스트 5  〉	통과 (5.57ms, 107MB)    통과 (37.09ms, 97.3MB)
테스트 6  〉	통과 (3.43ms, 92.9MB)   통과 (17.06ms, 94.8MB)
테스트 7  〉	통과 (3.92ms, 85.2MB)   통과 (9.97ms, 102MB)
테스트 8  〉	통과 (3.26ms, 97.9MB)   통과 (11.62ms, 80.1MB)
테스트 9  〉	통과 (4.25ms, 104MB)    통과 (8.39ms, 78.2MB)
테스트 10 〉	통과 (10.45ms, 126MB)   통과 (7.58ms, 116MB)
테스트 11 〉	통과 (0.04ms, 77.6MB)   통과 (0.05ms, 77.6MB)
테스트 12 〉	통과 (0.04ms, 68.7MB)   통과 (0.11ms, 67.9MB)
테스트 13 〉	통과 (4.67ms, 84.4MB)   통과 (8.65ms, 90.7MB)
테스트 14 〉	통과 (15.82ms, 116MB)   통과 (33.46ms, 129MB)
테스트 15 〉	통과 (10.77ms, 123MB)   통과 (41.70ms, 112MB)
테스트 16 〉	통과 (3.14ms, 105MB)    통과 (12.05ms, 92.1MB)

time complexity
solution1 - O(2^(2m))
solution2 - O(logN * (xe-xs) * (ye -ys))

시간 복잡도 자체는 solution1이 훨씬 안 좋지만 해당 문제에는 행의 개수가 최대 1024라는 제약 조건이 존재
재귀 깊이 한번 당 4번으로 쪼개지고 최대 재귀 깊이를 나타내는 m이 최대 5이므로 => 4^5 = 1024
2^10 = 1024이므로 O(1)

critical point

reference
https://programmers.co.kr/learn/courses/30/lessons/68936
*/
