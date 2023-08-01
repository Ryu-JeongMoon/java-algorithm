package algorithm.programmers.level2;

/**
 * k진수에서 소수 개수 구하기
 */
public class _92335 {

  public static void main(String[] args) {
    _92335 instance = new _92335();
    System.out.println(instance.solutionByStringBuilder(437674, 3));
    System.out.println(instance.solutionByStringBuilder(110011, 10));
    System.out.println(instance.solutionByStringBuilder(883438, 3));
  }

  public int solutionByStringBuilder(int n, int k) {
    String converted = Long.toString(n, k);
    int answer = 0;
    StringBuilder sb = new StringBuilder();
    for (char current : converted.toCharArray()) {
      if (current != '0') {
        sb.append(current);
      } else if (sb.length() != 0) {
        if (isPrime(Long.parseLong(sb.toString()))) {
          ++answer;
        }
        sb.setLength(0);
      }
    }
    return sb.length() != 0 && isPrime(Long.parseLong(sb.toString())) ? ++answer : answer;
  }

  public int solutionBySplit(int n, int k) {
    String converted = Long.toString(n, k);
    int answer = 0;
    String[] candidates = converted.split("0");
    for (String candidate : candidates) {
      if (!candidate.isEmpty() && isPrime(Long.parseLong(candidate))) {
        ++answer;
      }
    }
    return answer;
  }

  private boolean isPrime(long n) {
    for (long i = 3; i < (long) (Math.sqrt(n) + 1); i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return n > 1;
  }
}

/*
solutionByStringBuilder                    solutionBySplit
테스트 1  〉	통과 (9.18ms, 73.6MB)        테스트 1  〉	통과 (8.38ms, 79.5MB)
테스트 2  〉	통과 (0.08ms, 73.9MB)        테스트 2  〉	통과 (0.08ms, 73.7MB)
테스트 3  〉	통과 (0.16ms, 70.4MB)        테스트 3  〉	통과 (0.18ms, 77.8MB)
테스트 4  〉	통과 (0.15ms, 81.3MB)        테스트 4  〉	통과 (0.25ms, 73.1MB)
테스트 5  〉	통과 (0.13ms, 74.2MB)        테스트 5  〉	통과 (0.18ms, 76.6MB)
테스트 6  〉	통과 (0.10ms, 73.8MB)        테스트 6  〉	통과 (0.13ms, 78.5MB)
테스트 7  〉	통과 (0.11ms, 76.4MB)        테스트 7  〉	통과 (0.16ms, 78.1MB)
테스트 8  〉	통과 (0.09ms, 67.1MB)        테스트 8  〉	통과 (0.18ms, 70.6MB)
테스트 9  〉	통과 (0.17ms, 75.5MB)        테스트 9  〉	통과 (0.18ms, 77MB)
테스트 10 〉	통과 (0.10ms, 76MB)          테스트 10 〉	통과 (0.12ms, 65.5MB)
테스트 11 〉	통과 (0.10ms, 74.2MB)        테스트 11 〉	통과 (0.11ms, 73.7MB)
테스트 12 〉	통과 (0.09ms, 82.5MB)        테스트 12 〉	통과 (0.22ms, 74.1MB)
테스트 13 〉	통과 (0.19ms, 78.5MB)        테스트 13 〉	통과 (0.19ms, 73.4MB)
테스트 14 〉	통과 (0.18ms, 76.9MB)        테스트 14 〉	통과 (0.17ms, 73.6MB)
테스트 15 〉	통과 (0.16ms, 80MB)          테스트 15 〉	통과 (0.09ms, 76.8MB)
테스트 16 〉	통과 (0.09ms, 74.1MB)        테스트 16 〉	통과 (0.08ms, 75.1MB)

time complexity
N = splits.length
O(N)

critical point
211이 나온 경우, 이 숫자가 10진법일 때 소수인지 판별

reference
https://programmers.co.kr/learn/courses/30/lessons/92335
*/
