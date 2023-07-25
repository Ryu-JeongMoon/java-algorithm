package algorithm.programmers.level1;

/**
 * 키패드 누르기
 */
public class _67256 {

  public static void main(String[] args) {
    _67256 instance = new _67256();
    System.out.println(instance.solution(new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 }, "right"));
    System.out.println(instance.solution(new int[] { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 }, "left"));
    System.out.println(instance.solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }, "right"));
  }

  private static final String LEFT_HAND = "L", RIGHT_HAND = "R";
  private static final int LEFT_HAND_INDEX = 0, RIGHT_HAND_INDEX = 1;

  public String solution(int[] numbers, String hand) {
    int[] hands = new int[] { 10, 12 };
    int favoriteIndex = hand.charAt(0) == 'l' ? LEFT_HAND_INDEX : RIGHT_HAND_INDEX;
    StringBuilder sb = new StringBuilder();
    for (int number : numbers) {
      switch (number) {
        case 1, 4, 7 -> moveHand(hands, LEFT_HAND_INDEX, number, sb);
        case 3, 6, 9 -> moveHand(hands, RIGHT_HAND_INDEX, number, sb);
        case 2, 5, 8, 0 -> moveHand(hands, getIndex(number, hands, favoriteIndex), number, sb);
      }
    }
    return sb.toString();
  }

  private int getIndex(int number, int[] hands, int favoriteIndex) {
    int leftDistance = getDistance(hands[0], number);
    int rightDistance = getDistance(hands[1], number);
    return leftDistance > rightDistance ? RIGHT_HAND_INDEX : leftDistance < rightDistance ? LEFT_HAND_INDEX : favoriteIndex;
  }

  private void moveHand(int[] hands, int handIndex, int number, StringBuilder sb) {
    hands[handIndex] = number;
    sb.append(handIndex == 0 ? LEFT_HAND : RIGHT_HAND);
  }

  private int getDistance(int hand, int number) {
    number = number == 0 ? 11 : number;
    hand = hand == 0 ? 11 : hand;
    return switch (hand % 3) {
      case 1 -> Math.abs(++hand - number) / 3 + 1;
      case 2 -> Math.abs(hand - number) / 3;
      default -> Math.abs(--hand - number) / 3 + 1;
    };
  }
}

/*
time complexity
O(N)

critical point
0은 11로 치환
기존 손가락 위치가 2, 5, 8, 0에 있다면 종 이동
이 외에는 횡 이동이 추가로 필요 (4 -> 5, 6 -> 5, 9 -> 5, 1 -> 5 ..)

reference
https://programmers.co.kr/learn/courses/30/lessons/67256
*/
