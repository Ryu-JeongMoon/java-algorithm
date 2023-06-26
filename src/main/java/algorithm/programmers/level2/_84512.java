package algorithm.programmers.level2;

/**
 * 모음 사전
 */
public class _84512 {

  private static final char[] VOWEL = { 'A', 'E', 'I', 'O', 'U' };
  private static final String VOWEL_STRING = "AEIOU";

  public static void main(String[] args) {
    _84512 instance = new _84512();
    System.out.println(instance.solution("AAAAE"));
    System.out.println(instance.solution("AAAE"));
    System.out.println(instance.solution("I"));
    System.out.println(instance.solution("EIO"));
  }

  public int solution(String word) {
    return recursive(word, new StringBuilder(), 0);
  }

  private int recursive(String word, StringBuilder comparison, int count) {
    if (word.contentEquals(comparison)) {
      return count;
    }

    if (comparison.length() < 5) {
      comparison.append(VOWEL[0]);
    } else {
      int index = comparison.length() - 1;
      while (index > 0 && comparison.charAt(index) == 'U') {
        --index;
      }

      char c = comparison.charAt(index);
      String temp = comparison.substring(0, index);
      comparison.setLength(0);
      comparison.append(temp).append(VOWEL[VOWEL_STRING.indexOf(c) + 1]);
    }

    return recursive(word, comparison, ++count);
  }
}

/*
time complexity
n = word.length 일 때 O(5^n)

critical point
U가 아닌 문자의 인덱스 전까지 자른 후 다음 모음으로 치환
AAAAU -> AAA + (A -> E) = AAAE

reference
https://programmers.co.kr/learn/courses/30/lessons/84512
*/
