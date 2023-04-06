package algorithm.inflearn;

/**
 * 최대길이 바이토닉 수열
 */
public class _1_5 {

  public static void main(String[] args) {
    System.out.println(solution(new int[] { 1, 2, 1, 2, 3, 2, 1 }));
    System.out.println(solution(new int[] { 1, 1, 2, 3, 5, 7, 4, 3, 1, 2 }));
    System.out.println(solution(new int[] { 3, 2, 1, 3, 2, 4, 6, 7, 3, 1 }));
    System.out.println(solution(new int[] { 1, 3, 1, 2, 1, 5, 3, 2, 1, 1 }));
  }

  public static int solution(int[] nums) {
    int[] peaks = new int[nums.length];
    for (int i = 1; i < nums.length - 1; i++) {
      if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
        peaks[i] = i;
      }
    }

    int peakCount = 0;
    for (int peak : peaks) {
      if (peak != 0) {
        ++peakCount;
        break;
      }
    }
    if (peakCount == 0) {
      return 0;
    }

    int maxLength = 0;
    for (int peak : peaks) {
      if (peak == 0) {
        continue;
      }

      int length = 3, left = peak - 1, right = peak + 1;
      int count = Math.max(nums.length - left, nums.length - right);
      boolean leftFinished = false, rightFinished = false;
      while (--count >= 0) {
        if (left > 0 && nums[left] > nums[left - 1]) {
          ++length;
          --left;
        } else if (!leftFinished) {
          leftFinished = true;
        }

        if (right < nums.length - 1 && nums[right] > nums[right + 1]) {
          ++length;
          ++right;
        } else if (!rightFinished) {
          rightFinished = true;
        }

        if (leftFinished && rightFinished) {
          break;
        }
      }
      maxLength = Math.max(maxLength, length);
    }
    return maxLength;
  }
}

/*
time complexity
O(N)

critical point
바이토닉 수열이란 수열이 증가했다가 감소하는 수열

1. 후보군(peaks)을 찾아서 확장시켜 나가기
0이 아닌 인덱스 i가 있을 때 nums[i-1] < nums[i] && nums[i] > nums[i+1] 만족시켜야 함

2. 10개의 숫자 중 인덱스 5일 때
left = 4, right = 6 최대 몇번 확장시켜야 하는가?
total - left, total - right 중 큰 값이 최대 확장 횟수

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=149838
 */
