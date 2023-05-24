package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 토너먼트
 */
public class _1057 {

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    int kim = Integer.parseInt(s[1]);
    int lim = Integer.parseInt(s[2]);
    int count = 0;
    do {
      kim = (kim + 1) >> 1;
      lim = (lim + 1) >> 1;
      ++count;
    } while (kim != lim);
    System.out.print(count);
  }
}

/*
time complexity
O(logN)

critical point
kim, lim 은 서로 다른 자연수이므로 do-while 사용해 조건 검사를 뒤로 미룸 (그래봤자 한번 차이 ㅋ)

kim 짝수인 경우
kim+1 홀수로 만든 후 /2 이므로 kim/2 == kim+1/2
짝수%2==0이므로 (kim+1)/2 == kim/2+kim%2

kim 홀수인 경우
kim+1 짝수로 만든 후 /2, kim+1/2 == kim/2+1
홀수%2==1이므로 (kim+1)/2 == kim/2+kim%2

76ms,  (kim+1)/2;
144ms, (kim/2)+(kim%2);

reference
https://www.acmicpc.net/problem/1057
*/
