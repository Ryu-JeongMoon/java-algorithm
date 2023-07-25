package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 전화번호 목록
 */
public class _42577 {

  public static void main(String[] args) {
    _42577 instance = new _42577();
    System.out.println(instance.solutionByHashSet(new String[] { "119", "97674223", "1195524421" }));
    System.out.println(instance.solutionByHashSet(new String[] { "123", "456", "789" }));
    System.out.println(instance.solutionByHashSet(new String[] { "12", "123", "1235", "567", "88" }));
    System.out.println();
    System.out.println(instance.solutionBySort(new String[] { "119", "97674223", "1195524421" }));
    System.out.println(instance.solutionBySort(new String[] { "123", "456", "789" }));
    System.out.println(instance.solutionBySort(new String[] { "12", "123", "1235", "567", "88" }));
  }

  public boolean solutionByHashSet(String[] phoneNumbers) {
    Set<String> prefixes = new HashSet<>();
    for (String phoneNumber : phoneNumbers) {
      for (int i = 1; i < phoneNumber.length(); i++) {
        prefixes.add(phoneNumber.substring(0, i));
      }
    }

    return Arrays.stream(phoneNumbers)
      .noneMatch(prefixes::contains);
  }

  public boolean solutionBySort(String[] phoneNumbers) {
    Arrays.sort(phoneNumbers);
    for (int i = 0; i < phoneNumbers.length - 1; i++) {
      if (phoneNumbers[i + 1].startsWith(phoneNumbers[i])) {
        return false;
      }
    }
    return true;
  }
}

/*
solutionByHashSet                          solutionBySort
정확성  테스트
테스트 1  〉	통과 (0.98ms, 73.2MB)        테스트 1  〉	통과 (0.30ms, 71.6MB)
테스트 2  〉	통과 (1.49ms, 90.3MB)        테스트 2  〉	통과 (0.16ms, 72.6MB)
테스트 3  〉	통과 (1.47ms, 74.7MB)        테스트 3  〉	통과 (0.30ms, 73.9MB)
테스트 4  〉	통과 (1.06ms, 70.3MB)        테스트 4  〉	통과 (0.25ms, 74.5MB)
테스트 5  〉	통과 (1.12ms, 71.7MB)        테스트 5  〉	통과 (0.43ms, 73.1MB)
테스트 6  〉	통과 (1.07ms, 86MB)          테스트 6  〉	통과 (0.21ms, 77.2MB)
테스트 7  〉	통과 (1.03ms, 75.5MB)        테스트 7  〉	통과 (0.30ms, 84.9MB)
테스트 8  〉	통과 (0.92ms, 76.2MB)        테스트 8  〉	통과 (0.20ms, 73.1MB)
테스트 9  〉	통과 (1.12ms, 74.5MB)        테스트 9  〉	통과 (0.18ms, 66.4MB)
테스트 10 〉	통과 (1.14ms, 73.1MB)        테스트 10 〉	통과 (0.17ms, 72.3MB)
테스트 11 〉	통과 (1.39ms, 83.4MB)        테스트 11 〉	통과 (0.22ms, 76MB)
테스트 12 〉	통과 (1.41ms, 76.9MB)        테스트 12 〉	통과 (0.20ms, 73MB)
테스트 13 〉	통과 (1.05ms, 73.1MB)        테스트 13 〉	통과 (0.17ms, 71.5MB)
테스트 14 〉	통과 (3.26ms, 77.5MB)        테스트 14 〉	통과 (2.86ms, 82.6MB)
테스트 15 〉	통과 (3.95ms, 79.9MB)        테스트 15 〉	통과 (2.24ms, 66.1MB)
테스트 16 〉	통과 (10.08ms, 76.9MB)       테스트 16 〉	통과 (2.38ms, 71.3MB)
테스트 17 〉	통과 (14.91ms, 88.6MB)       테스트 17 〉	통과 (2.92ms, 78.7MB)
테스트 18 〉	통과 (10.13ms, 88.8MB)       테스트 18 〉	통과 (3.65ms, 78.3MB)
테스트 19 〉	통과 (11.99ms, 79.7MB)       테스트 19 〉	통과 (3.64ms, 73.5MB)
테스트 20 〉	통과 (12.18ms, 79.1MB)       테스트 20 〉	통과 (4.41ms, 80MB)

효율성  테스트
테스트 1 〉	통과 (37.24ms, 66MB)           테스트 1 〉  통과 (24.73ms, 56.4MB)
테스트 2 〉	통과 (40.89ms, 67.2MB)         테스트 2 〉  통과 (19.75ms, 56.6MB)
테스트 3 〉	통과 (332.52ms, 228MB)         테스트 3 〉  통과 (412.77ms, 97.5MB)
테스트 4 〉	통과 (2335.27ms, 419MB)        테스트 4 〉  통과 (264.49ms, 95.4MB)

time complexity
N : phoneNumbers.length, M : average phoneNumbers[i].length() 라고 할 때
N은 1 이상 1,000,000 이하, M은 1 이상 20 이하
N이 지배적이므로 Sort 방식이 더 효율적
solutionByHashSet : O(N*M)
solutionBySort    : O(NMlog(N))

critical point
복잡한 문제의 경우 전처리가 중요

reference
https://programmers.co.kr/learn/courses/30/lessons/42577
*/
