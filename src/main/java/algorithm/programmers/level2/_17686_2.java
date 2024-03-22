package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * [3차] 파일명 정렬
 */
public class _17686_2 {

  public static void main(String[] args) {
    _17686_2 instance = new _17686_2();
    System.out.println(Arrays.toString(instance.solution(new String[] { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" })));
    System.out.println(Arrays.toString(instance.solution(new String[] { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat" })));
    System.out.println(Arrays.toString(instance.solution(new String[] { "F-15", "F-15", "F-15", "F-15" })));
  }

  public String[] solution(String[] files) {
    StringBuilder sb = new StringBuilder();
    return Arrays.stream(files)
      .map(s -> s.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)"))
      .sorted(Comparator.comparing((String[] s) -> s[0].toLowerCase())
        .thenComparing((String[] s) -> Integer.parseInt(s[1])))
      .map(s -> {
        sb.setLength(0);
        for (String string : s) {
          sb.append(string);
        }
        return sb.toString();
      })
      .toArray(String[]::new);
  }
}

/*
time complexity
O(NlogN)

critical point
              1.                        2.
테스트 1  〉	통과 (6.71ms, 75.3MB)     통과 (5.58ms, 66.4MB)
테스트 2  〉	통과 (6.66ms, 78.9MB)     통과 (6.14ms, 75.3MB)
테스트 3  〉	통과 (140.40ms, 149MB)    통과 (46.40ms, 112MB)
테스트 4  〉	통과 (189.58ms, 125MB)    통과 (61.42ms, 91MB)
테스트 5  〉	통과 (145.35ms, 124MB)    통과 (43.47ms, 104MB)
테스트 6  〉	통과 (190.73ms, 140MB)    통과 (42.25ms, 101MB)
테스트 7  〉	통과 (168.31ms, 145MB)    통과 (56.37ms, 105MB)
테스트 8  〉	통과 (156.18ms, 127MB)    통과 (33.62ms, 100MB)
테스트 9  〉	통과 (114.60ms, 125MB)    통과 (39.42ms, 96.3MB)
테스트 10 〉	통과 (124.47ms, 127MB)    통과 (33.09ms, 101MB)
테스트 11 〉	통과 (166.57ms, 133MB)    통과 (39.98ms, 105MB)
테스트 12 〉	통과 (130.54ms, 137MB)    통과 (30.40ms, 95.3MB)
테스트 13 〉	통과 (43.62ms, 112MB)     통과 (30.00ms, 100MB)
테스트 14 〉	통과 (55.82ms, 115MB)     통과 (32.23ms, 86.8MB)
테스트 15 〉	통과 (63.62ms, 124MB)     통과 (42.52ms, 104MB)
테스트 16 〉	통과 (163.14ms, 140MB)    통과 (37.22ms, 106MB)
테스트 17 〉	통과 (49.37ms, 110MB)     통과 (43.16ms, 103MB)
테스트 18 〉	통과 (85.04ms, 130MB)     통과 (27.08ms, 92.8MB)
테스트 19 〉	통과 (137.24ms, 134MB)    통과 (33.31ms, 96.1MB)
테스트 20 〉	통과 (112.01ms, 142MB)    통과 (36.12ms, 101MB)

reference
https://school.programmers.co.kr/learn/courses/30/lessons/17686
*/
