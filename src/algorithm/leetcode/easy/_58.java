package algorithm.leetcode.easy;

/**
 * 58. Length of Last Word
 */
public class _58 {

  public static void main(String[] args) {
    System.out.println(lengthOfLastWord("Hello World"));
    System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    System.out.println(lengthOfLastWord2("luffy is still joyboy"));
    System.out.println(lengthOfLastWord2("luff y"));
  }

  // 1 ms	40.6 MB
  public static int lengthOfLastWord(String s) {
    return new StringBuilder(s.trim())
      .reverse()
      .toString()
      .split(" ")[0].length();
  }

  // 0 ms	41.9 MB
  public static int lengthOfLastWord2(String s) {
    s = s.trim();
    return s.length() - s.lastIndexOf(" ") - 1;
  }
}

/*
time complexity
공백이 없는 입력이 오는 최악의 경우, 단어 하나하나 세어야 되므로 O(n)

critical point
뒤에서부터 공백을 만나기 전까지 단어 개수를 세면 된다
 */