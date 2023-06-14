package algorithm.programmers.level1;

/**
 * 이상한 문자 만들기
 */
public class _12930 {

  public static void main(String[] args) {
    _12930 instance = new _12930();
    System.out.println(instance.solutionByCharacter("try hello world"));
    System.out.println(instance.solutionByString("try hello world"));
  }

  public String solutionByCharacter(String s) {
    StringBuilder sb = new StringBuilder();
    int index = 0;
    for (char c : s.toCharArray()) {
      sb.append(index % 2 == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c));
      index = c == ' ' ? 0 : index + 1;
    }
    return sb.toString();
  }

  public String solutionByString(String s) {
    StringBuilder answer = new StringBuilder();
    int cnt = 0;
    for (String temp : s.split("")) {
      cnt = temp.equals(" ") ? 0 : cnt + 1;
      answer.append(cnt % 2 == 0 ? temp.toLowerCase() : temp.toUpperCase());
    }
    return answer.toString();
  }
}

/*
time complexity
O(s.length)

critical point
공백이 둘 이상인 경우도 고려해야 함

reference
https://programmers.co.kr/learn/courses/30/lessons/12930
 */
