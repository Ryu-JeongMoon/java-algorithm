package algorithm.programmers.level2;

import java.util.Arrays;

/**
 * H-Index
 */
public class _42747 {

  public static void main(String[] args) {
    _42747 instance = new _42747();
    System.out.println(instance.solution(new int[]{ 0, 0, 0 }));
    System.out.println(instance.solution(new int[]{ 1, 3, 5, 7, 9, 11 }));
    System.out.println(instance.solution(new int[]{ 3, 0, 6, 1, 5 }));
    System.out.println(instance.solution(new int[]{ 0, 0, 0, 0, 0 }));
    System.out.println(instance.solution(new int[]{ 0, 0, 0, 0, 1 }));
    System.out.println(instance.solution(new int[]{ 9, 9, 9, 12 }));
    System.out.println(instance.solution(new int[]{ 9, 7, 6, 2, 1 }));
    System.out.println(instance.solution(new int[]{ 10, 8, 5, 4, 3 }));
    System.out.println(instance.solution(new int[]{ 25, 8, 5, 3, 3 }));
    System.out.println(instance.solution(new int[]{ 1, 1, 5, 7, 6 }));
    System.out.println(instance.solution(new int[]{ 0 }));
    System.out.println(instance.solution(new int[]{ 0, 0 }));
  }

  public int solution(int[] citations) {
    Arrays.sort(citations);
    int numberOfPapers = citations.length, answer = 0;
    for (int i = numberOfPapers - 1; i > -1; i--) {
      answer = Math.max(answer, Math.min(numberOfPapers - i, citations[i]));
      if (numberOfPapers - i >= citations[i]) {
        break;
      }
    }
    return answer;
  }
}

/*
time complexity
O(NlogN)

critical point
https://www.ibric.org/myboard/read.php?Board=news&id=270333
H-지수 구하는 방법
1. 자신이 저널에 등재한 전체 논문중 많이 인용된 순으로 정렬한 후
Arrays.sort(citations);
2. 피인용수가 논문수와 같아지거나 피인용수가 논문수보다 작아지기 시작하는 숫자가 바로 나의 h
answer = Math.max(answer, Math.min(numberOfPapers - i, citations[i]));

https://school.programmers.co.kr/questions/20906
{ input: [1, 3, 5, 7, 9, 11], answer: 4 }
{ input: [3, 0, 6, 1, 5], answer: 3 },
{ input: [0, 0, 0, 0, 0], answer: 0 },
{ input: [0, 0, 0, 0, 1], answer: 1 },
{ input: [9, 9, 9, 12], answer: 4 },
{ input: [9, 7, 6, 2, 1], answer: 3 },
{ input: [10, 8, 5, 4, 3], answer: 4 },
{ input: [25, 8, 5, 3, 3], answer: 3 },
{ input: [1, 1, 5, 7, 6], answer: 3 },
{ input: [0], answer: 0 },
{ input: [0, 0], answer: 0 }

reference
https://programmers.co.kr/learn/courses/30/lessons/42747
*/
