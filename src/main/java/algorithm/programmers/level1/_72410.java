package algorithm.programmers.level1;

/**
 * 신규 아이디 추천
 */
public class _72410 {

  public static void main(String[] args) {
    _72410 instance = new _72410();
    System.out.println(instance.solution("...!@BaT#*..y.abcdefghijklm"));
    System.out.println(instance.solution("z-+.^."));
    System.out.println(instance.solution("=.="));
    System.out.println(instance.solution(".a..a..b..c..=.="));
    System.out.println(instance.solution("123_.def"));
    System.out.println(instance.solution("abcdefghijklmn.p"));
  }

  public String solution(String new_id) {
    new_id = new_id.toLowerCase().replaceAll("[^a-z0-9-_.]", "");
    new_id = new_id.contains("..") ? new_id.replaceAll("[.]{2,}", ".") : new_id;
    new_id = new_id.startsWith(".") ? new_id.replaceFirst(".", "") : new_id;
    new_id = new_id.endsWith(".") ? new_id.substring(0, new_id.length() - 1) : new_id;
    if (new_id.isEmpty()) {
      return "aaa";
    }

    new_id = new_id.length() > 15 ? new_id.substring(0, 15) : new_id;
    new_id = new_id.endsWith(".") ? new_id.substring(0, new_id.length() - 1) : new_id;
    String lastChar = new_id.substring(new_id.length() - 1);
    return new_id.length() < 3 ? new_id + lastChar.repeat(3 - new_id.length()) : new_id;
  }
}

/*
time complexity
O(n)

critical point
"[.]{2,}"
2개 이상의 .을 1개의 .으로 치환

reference
https://programmers.co.kr/learn/courses/30/lessons/72410
*/
