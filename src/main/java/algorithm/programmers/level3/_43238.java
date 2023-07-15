package algorithm.programmers.level3;

/**
 * 입국심사
 */
public class _43238 {

  public static void main(String[] args) {
    _43238 instance = new _43238();
    System.out.println(instance.solution(6, new int[] { 7, 10 }));
    System.out.println(instance.solution(59, new int[] { 1, 1 }));
  }

  public long solution(int n, int[] times) {
    long start = 0, end = (long) Math.pow(10, 18), totalTime;
    while (start < end) {
      totalTime = (start + end) / 2;
      long throughput = findThroughput(totalTime, times);

      if (n > throughput) {
        start = totalTime + 1;
      } else {
        end = totalTime;
      }
    }
    return findMinimum(start, times);
  }

  private long findThroughput(long totalTime, int[] times) {
    long throughput = 0;
    for (int time : times) {
      throughput += (totalTime / time);
    }
    return throughput;
  }

  private long findMinimum(long totalTime, int[] times) {
    long minimumRemains = Long.MAX_VALUE;
    for (int time : times) {
      minimumRemains = Math.min(minimumRemains, totalTime % time);
    }
    return totalTime - minimumRemains;
  }
}

/*
time complexity
n = times.length
O(n)

critical point
제한 사항 잘 읽기 !!

대기 인원 [1, 10^9]
심사 시간 [1, 10^9]
심사관    [1, 10^6]
심사관 한명 & 대기 인원 최대인 경우, 최대 심사 시간은 10^18

reference
https://programmers.co.kr/learn/courses/30/lessons/43238
*/
