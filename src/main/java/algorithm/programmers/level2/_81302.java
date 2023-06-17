package algorithm.programmers.level2;

import java.util.Arrays;

/**
 * 거리두기 확인하기
 */
public class _81302 {

  private static final char PERSON = 'P';
  private static final char EMPTY_TABLE = 'O';
  private static final char PARTITION = 'X';
  private static final int WAITING_ROOM_SIZE = 5;

  public static void main(String[] args) {
    String[][] places = {
      { "POOOP",
        "OXXOX",
        "OPXPX",
        "OOXOX",
        "POXXP" },

      { "POOPX",
        "OXPXP",
        "PXXXO",
        "OXXXO",
        "OOOPP" },

      { "PXOPX",
        "OXOXP",
        "OXPOX",
        "OXXOP",
        "PXPOX" },

      { "OOOXX",
        "XOOOX",
        "OOOXX",
        "OXOOX",
        "OOOOO" },

      { "PXPXP",
        "XPXPX",
        "PXPXP",
        "XPXPX",
        "PXPXP" }

      // {"POOOP", "OXXOX", "OXXPX", "OPXOX", "PXXXP"}
    };

    System.out.println(Arrays.toString(new _81302().solution(places)));
  }

  public int[] solution(String[][] places) {
    int[] answer = new int[WAITING_ROOM_SIZE];
    Arrays.fill(answer, 1);

    for (int i = 0; i < WAITING_ROOM_SIZE; i++) {
      solvePerWaitingRoom(places, answer, i);
    }

    return answer;
  }

  private void solvePerWaitingRoom(String[][] places, int[] answer, int i) {
    outer:
    for (int j = 0; j < WAITING_ROOM_SIZE; j++) {
      for (int k = 0; k < WAITING_ROOM_SIZE; k++) {
        if (places[i][j].charAt(k) == PERSON &&
          (existsInContactSurface(j, k, places[i])
            || existsInDoubleJump(j, k, places[i])
            || existsInRightDiagonally(j, k, places[i])
            || existsInLeftDiagonally(j, k, places[i]))
        ) {

          answer[i] = 0;
          break outer;
        }
      }
    }
  }

  private boolean existsInContactSurface(int j, int k, String[] placesInWaitingRoom) {
    return (k < WAITING_ROOM_SIZE - 1 && placesInWaitingRoom[j].charAt(k + 1) == PERSON)
      || (j < WAITING_ROOM_SIZE - 1 && placesInWaitingRoom[j + 1].charAt(k) == PERSON);
  }

  private boolean existsInLeftDiagonally(int j, int k, String[] placesInWaitingRoom) {
    return k > 0 && j < WAITING_ROOM_SIZE - 1
      && (placesInWaitingRoom[j].charAt(k - 1) == EMPTY_TABLE || placesInWaitingRoom[j + 1].charAt(k) == EMPTY_TABLE)
      && placesInWaitingRoom[j + 1].charAt(k - 1) == PERSON;
  }

  private boolean existsInRightDiagonally(int j, int k, String[] placesInWaitingRoom) {
    return j < WAITING_ROOM_SIZE - 1
      && k < WAITING_ROOM_SIZE - 1
      && (placesInWaitingRoom[j].charAt(k + 1) == EMPTY_TABLE || placesInWaitingRoom[j + 1].charAt(k) == EMPTY_TABLE)
      && placesInWaitingRoom[j + 1].charAt(k + 1) == PERSON;
  }

  private boolean existsInDoubleJump(int j, int k, String[] placesInWaitingRoom) {
    return (k < WAITING_ROOM_SIZE - 2 && placesInWaitingRoom[j].charAt(k + 1) != PARTITION && placesInWaitingRoom[j].charAt(k + 2) == PERSON)
      || (j < WAITING_ROOM_SIZE - 2 && placesInWaitingRoom[j + 1].charAt(k) != PARTITION && placesInWaitingRoom[j + 2].charAt(k) == PERSON);
  }
}

/*
time complexity
O(WAITING_ROOM_SIZE^3)

critical point
두 테이블 T1, T2가 행렬 (r1, c1), (r2, c2)에 각각 위치하고 있다면, T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2| 입니다

1. 맞닿아 있는 부분 확인 (a, b+1) / (a+1, b)
  1-1. 둘 중 하나라도 사람인 경우 -> 0 넣고 break;
  1-2. 둘 다 파티션인 경우        -> (a, b-1) 빈 테이블이라면 (a+1, b-1)만 확인
  1-3. 둘 다 빈 테이블인 경우     -> 나머지 확인

a,b라면
a-2 / b
a-1 / b-1, b, b+1
a   / b-2, b-1, b, b+1, b+2
a+1 / b-1, b, b+1
a+2 / b

reference
https://programmers.co.kr/learn/courses/30/lessons/81302
*/
