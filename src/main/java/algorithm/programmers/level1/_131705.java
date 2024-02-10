package algorithm.programmers.level1;

/**
 * 삼총사
 */
public class _131705 {

  public static void main(String[] args) {
    _131705 instance = new _131705();
    System.out.println(instance.solution(new int[] { -2, 3, 0, 2, -5 }));
    System.out.println(instance.solution(new int[] { -3, -2, -1, 0, 1, 2, 3 }));
    System.out.println(instance.solution(new int[] { -1, 1, -1, 1 }));
  }

  private int solution(int[] number) {
    int answer = 0, length = number.length;
    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        for (int k = j + 1; k < length; k++) {
          if (number[i] + number[j] + number[k] == 0) {
            answer++;
          }
        }
      }
    }
    return answer;
  }
}

/*
time complexity
O(N^3)

critical point

reference
https://programmers.co.kr/learn/courses/30/lessons/131705
*/
