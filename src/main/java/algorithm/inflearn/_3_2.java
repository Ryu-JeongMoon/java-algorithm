package algorithm.inflearn;

import java.util.ArrayDeque;
import java.util.regex.Pattern;

/**
 * 겹쳐진 압축 해제
 */
public class _3_2 {

  private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d");

  public static void main(String[] args) {
    // abbabbabbef
    System.out.println(solution("3(a2(b))ef"));

    // ababkbcbcbc
    System.out.println(solution("2(ab)k3(bc)"));

    // abcdcdcdabcdcdcd
    System.out.println(solution("2(ab3((cd)))"));

    // ababacacacacacacababacacacacacac
    System.out.println(solution("2(2(ab)3(2(ac)))"));

    // absgsgabsgsgabsgsg
    System.out.println(solution("3(ab2(sg))"));
  }

  public static String solution(String s) {
    StringBuilder current = new StringBuilder(), number = new StringBuilder();
    ArrayDeque<String> characters = new ArrayDeque<>();

    for (String value : s.split("")) {
      if (!value.equals(")")) {
        characters.offerLast(value);
        continue;
      }

      int size = characters.size();
      for (int j = 0; j < size; j++) {
        if (!characters.isEmpty() && !characters.peekLast().equals("(")) {
          current.insert(0, characters.pollLast());
        } else {
          characters.pollLast();
          break;
        }
      }

      size = characters.size();
      for (int i = 0; i < size; i++) {
        // numbers are always less or equal than 2 digits
        if (!characters.isEmpty() && NUMERIC_PATTERN.matcher(characters.peekLast()).matches()) {
          number.insert(0, characters.pollLast());
        } else {
          break;
        }
      }

      if (!number.isEmpty()) {
        int repeatCount = Integer.parseInt(number.toString());
        current.append(String.valueOf(current).repeat(Math.max(0, repeatCount - 1)));
      }

      characters.offerLast(String.valueOf(current));
      // for reusing StringBuilder
      current.setLength(0);
      number.setLength(0);
    }

    while (!characters.isEmpty()) {
      current.insert(0, characters.pollLast());
    }
    return current.toString();
  }
}

/*
time complexity
O(N^2) Stack, Deque are same

- GPT says
The time complexity of this code depends on the size of the input string s and the number of nested parentheses in the string.
Let n be the length of the input string and p be the maximum depth of nested parentheses in the string.
In the worst case, every character in the string may be enclosed in parentheses, so p is at most n/2.

The code consists of a single loop that iterates over every character in the input string,
and a final loop that processes the remaining characters in the deque.
The time complexity of the loop is O(n), since it processes each character in the input string exactly once.
The time complexity of the final loop is also O(n), since it processes each remaining character in the deque exactly once.
Within the main loop, the code performs several operations on the deque, such as adding and
removing elements, peeking at the last element, and computing the size of the deque.

These operations take constant time, so they do not affect the overall time complexity.
The most time-consuming operation within the main loop is the repeat operation,
which repeats the current substring a certain number of times.
Since the maximum number of repetitions is 99, this operation takes constant time.
Therefore, the overall time complexity of the code is O(n*p),
where n is the length of the input string and p is the maximum depth of nested parentheses in the string.
However, since p is at most n/2, the worst-case time complexity of the code is O(n^2).

critical point
임시로 만들어지는 문자열을 외부에 저장할 필요 없음
스택에 다시 집어넣고 다음 반복 때 순서대로 맞춰짐!!

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=149916
 */
