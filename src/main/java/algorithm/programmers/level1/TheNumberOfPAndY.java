package algorithm.programmers.level1;

public class TheNumberOfPAndY {

  public static void main(String[] args) {
    System.out.println(solution("pPoooyY"));
    System.out.println(solution("Pyy"));
  }

  static boolean solution(String s) {
    int count = 0;
    String lowerCased = s.toLowerCase();
    for (int i = 0; i < lowerCased.length(); i++) {
      if (lowerCased.charAt(i) == 'p') {
        ++count;
      } else if (lowerCased.charAt(i) == 'y') {
        --count;
      }
    }
    return count == 0;
  }
}
