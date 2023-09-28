package algorithm.programmers.level2;

import static algorithm.util.PrimeUtils.*;

import java.util.HashSet;
import java.util.Set;

/**
 * 소수 찾기
 */
public class _42839 {

  public static void main(String[] args) {
    _42839 instance = new _42839();
    System.out.println(instance.solution("17"));
    System.out.println(instance.solution("011"));
    System.out.println(instance.solution("631"));
  }

  public int solution(String numbers) {
    Set<String> strings = new HashSet<>();
    visit(numbers, strings, new boolean[numbers.length()], "");

    Set<Integer> primes = new HashSet<>();
    for (String s : strings) {
      int n = Integer.parseInt(s);
      if (!primes.contains(n) && isPrime(n)) {
        primes.add(n);
      }
    }
    return primes.size();
  }

  private void visit(String numbers, Set<String> numberSet, boolean[] visited, String current) {
    if (current.length() >= numbers.length()) {
      return;
    }

    for (int i = 0; i < numbers.length(); i++) {
      if (!visited[i]) {
        visited[i] = true;
        String temporary = current + numbers.charAt(i);
        numberSet.add(temporary);
        visit(numbers, numberSet, visited, temporary);
        visited[i] = false;
      }
    }
  }
}

/*
time complexity
N: numbers.length
O(2^N)

critical point
1. visited dfs
if (!visited[i]) {
  visited[i] = true;
  String temporary = current + numbers.charAt(i);
  numberSet.add(temporary);
  visit(numbers, numberSet, visited, temporary);
  visited[i] = false;
}

특정 번호 node 부터 시작하여 끝까지 방문 후
다음 번호 node

2. int casting
(int) (Math.sqrt(n) + 1) vs Math.sqrt(n) + 1
int casting -> (int) (Math.sqrt(n) + 1) == 2, 2를 스킵할 수 있도록 함
후자는 double 형으로 계산되어 2를 스킵할 수 없어 소수가 아니라 판단됨

reference
https://programmers.co.kr/learn/courses/30/lessons/42839
*/
