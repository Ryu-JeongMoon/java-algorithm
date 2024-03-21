package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * [3차] 파일명 정렬
 */
public class _17686 {

  public static void main(String[] args) {
    _17686 instance = new _17686();
    System.out.println(Arrays.toString(instance.solution(new String[] { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" })));
    System.out.println(Arrays.toString(instance.solution(new String[] { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat" })));
    System.out.println(Arrays.toString(instance.solution(new String[] { "F-15", "F-15", "F-15", "F-15" })));
  }

  public String[] solution(String[] files) {
    String regex = "(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)";
    Arrays.sort(files, Comparator.comparing((String s) -> s.split(regex)[0].toLowerCase())
      .thenComparing((String s) -> Integer.parseInt(s.split(regex)[1])));
    return files;
  }
}

/*
time complexity
O(NlogN)

critical point
정규식을 사용한 문자열 분리
(?<=\\D)(?=\\d) : 문자열과 숫자 사이
(?<=\\d)(?=\\D) : 숫자와 문자열 사이

?<= : 긍정형 전방 탐색
(?<=a)b : a 뒤에 b가 있는 경우

?= : 긍정형 후방 탐색
a(?=b) : b 앞에 a가 있는 경우

reference
https://school.programmers.co.kr/learn/courses/30/lessons/17686
*/
