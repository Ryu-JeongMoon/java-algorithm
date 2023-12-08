package algorithm.solvedac.silver_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 참외밭
 */
public class _2477 {

  private static final int LENGTH = 6;

  public static void main(String[] args) throws IOException {
    int k = nextInt(), maxWidth = 0, maxHeight = 0;
    int[][] array = new int[LENGTH][2];
    for (int i = 0; i < LENGTH; i++) {
      int direction = nextInt(), value = nextInt();
      if (direction > 2) {
        maxHeight = Math.max(maxHeight, value);
      } else {
        maxWidth = Math.max(maxWidth, value);
      }
      array[i] = new int[] { direction, value };
    }

    int previousWidthDirection = 0, previousHeightDirection = 0, targetWidth = 0, targetHeight = 0;
    for (int i = 0; i < LENGTH + 2; i++) {
      int direction = array[i % LENGTH][0];
      if (direction > 2) {
        if (direction == previousHeightDirection) {
          targetWidth = array[(i - 1) % LENGTH][1];
        } else {
          previousHeightDirection = direction;
        }
      } else {
        if (direction == previousWidthDirection) {
          targetHeight = array[(i - 1) % LENGTH][1];
        } else {
          previousWidthDirection = direction;
        }
      }
    }
    System.out.println(k * (maxWidth * maxHeight - targetWidth * targetHeight));
  }
}

/*
time complexity
O(1)

critical point
┏------┓
|      |
|  ┏---┛
|  |    ⬅️target height
┗--┛
     ⬆️
     target width

가로 방향 == 이전 가로 방향인 경우, 타겟 세로 길이 저장
세로 방향 == 이전 세로 방향인 경우, 타겟 가로 길이 저장
면적 = 최대 가로 길이 * 최대 세로 길이 - 타겟 가로 길이 * 타겟 세로 길이

연속 방향이 array[1][0], array[5][0]인 경우 존재 가능
array[5][0] == array[(5+2) % LENGTH][0]까지 비교해야 하므로
두번째 반복문에서 LENGTH + 2 만큼 반복

가로 / 세로로 나눠 같은 방향을 연속으로 만나는 경우, 끼인 길이를 구함
입력 순서가 정해져있으므로 사용할 수 있는 방법

reference
https://www.acmicpc.net/problem/2477
*/
