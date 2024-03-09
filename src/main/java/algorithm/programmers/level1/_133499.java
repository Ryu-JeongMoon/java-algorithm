package algorithm.programmers.level1;

import java.util.Set;

/**
 * 옹알이(2)
 */
public class _133499 {

  private static final Set<String> PRONUNCIATION = Set.of("aya", "ye", "woo", "ma");

  public static void main(String[] args) {
    _133499 instance = new _133499();
    System.out.println(instance.solution(new String[] { "aya", "yee", "u", "maa" }));
    System.out.println(instance.solution(new String[] { "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa" }));
  }

  public int solution(String[] babbling) {
    int answer = 0;

    StringBuilder previous = new StringBuilder();
    for (String word : babbling) {
      int previousIndex = 0, index = 0, length = word.length();
      while (index != length) {
        for (String pronunciation : PRONUNCIATION) {
          if (word.startsWith(pronunciation, index) && !pronunciation.contentEquals(previous)) {
            index += pronunciation.length();
            previous.setLength(0);
            previous.append(pronunciation);
            break;
          }
        }

        if (previousIndex == index) {
          break;
        } else {
          previousIndex = index;
        }
      }

      if (index == length) {
        answer++;
      }
      previous.setLength(0);
    }
    return answer;
  }
}

/*
time complexity
O(N^2)

critical point
String Handling, replace 도 나쁘지 않을듯...?

reference
https://school.programmers.co.kr/learn/courses/30/lessons/133499
*/
