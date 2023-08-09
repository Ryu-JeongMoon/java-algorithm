package algorithm.programmers.level2;

/**
 * N진수 게임
 */
public class _17687 {

  public static void main(String[] args) {
    _17687 instance = new _17687();
    System.out.println(instance.solution(2, 4, 2, 1));
    System.out.println(instance.solution(16, 16, 2, 1));
    System.out.println(instance.solution(16, 16, 2, 2));
  }

  public String solution(int notation, int count, int numberOfPeople, int order) {
    StringBuilder sb = new StringBuilder();
    int totalCount = numberOfPeople * (count - 1) + order;
    int number = 0;
    while (sb.length() < totalCount) {
      sb.append(Integer.toString(number++, notation));
    }

    int index = order - 1;
    while (index < totalCount) {
      char current = sb.charAt(index);
      sb.append(Character.isDigit(current) ? current : Character.toUpperCase(current));
      index += numberOfPeople;
    }
    return sb.substring(sb.length() - count);
  }
}

/*
time complexity
O(N)

critical point
StringBuilder 재활용

reference
https://programmers.co.kr/learn/courses/30/lessons/17687
*/
