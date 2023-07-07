package algorithm.programmers.level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 문자열 내림차순으로 배치하기
 */
public class _12917 {

  public static void main(String[] args) {
    _12917 instance = new _12917();
    System.out.println(instance.solution1("Zbcdefg"));
    System.out.println(instance.solution2("Zbcdefg"));
  }

  public String solution1(String s) {
    return Arrays.stream(s.split(""))
      .sorted(Comparator.reverseOrder())
      .collect(Collectors.joining());
  }

  public String solution2(String s) {
    return s.chars().sorted()
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .reverse()
      .toString();
  }
}

/*
solution1                               solution2
테스트 1  〉	통과 (3.12ms, 77.2MB)     테스트 1  〉	통과 (3.63ms, 73.3MB)
테스트 2  〉	통과 (3.29ms, 86.8MB)     테스트 2  〉	통과 (2.61ms, 80.1MB)
테스트 3  〉	통과 (3.72ms, 65.8MB)     테스트 3  〉	통과 (3.43ms, 77.3MB)
테스트 4  〉	통과 (3.92ms, 77.5MB)     테스트 4  〉	통과 (2.59ms, 77.8MB)
테스트 5  〉	통과 (6.47ms, 73.2MB)     테스트 5  〉	통과 (3.70ms, 78.2MB)
테스트 6  〉	통과 (5.03ms, 77.2MB)     테스트 6  〉	통과 (2.24ms, 77.2MB)
테스트 7  〉	통과 (2.01ms, 72.7MB)     테스트 7  〉	통과 (6.80ms, 79.3MB)
테스트 8  〉	통과 (2.53ms, 72.9MB)     테스트 8  〉	통과 (3.14ms, 78.4MB)
테스트 9  〉	통과 (4.97ms, 71.5MB)     테스트 9  〉	통과 (3.19ms, 74.8MB)
테스트 10 〉	통과 (2.16ms, 74.9MB)     테스트 10 〉	통과 (2.30ms, 70.8MB)
테스트 11 〉	통과 (2.49ms, 75.9MB)     테스트 11 〉	통과 (2.35ms, 77.8MB)
테스트 12 〉	통과 (2.06ms, 86MB)       테스트 12 〉	통과 (2.07ms, 77MB)
테스트 13 〉	통과 (1.91ms, 75.1MB)     테스트 13 〉	통과 (3.24ms, 79.6MB)
테스트 14 〉	통과 (1.82ms, 79.9MB)     테스트 14 〉	통과 (2.39ms, 71.9MB)
테스트 15 〉	통과 (1.77ms, 71.4MB)     테스트 15 〉	통과 (2.27ms, 76.3MB)
테스트 16 〉	통과 (2.07ms, 77.3MB)     테스트 16 〉	통과 (2.07ms, 73MB)

time complexity
solution1: O(nlogn)
solution2: O(nlogn)

critical point

reference
https://programmers.co.kr/learn/courses/30/lessons/12917
*/
