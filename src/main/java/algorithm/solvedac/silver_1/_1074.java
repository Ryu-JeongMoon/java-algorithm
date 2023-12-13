package algorithm.solvedac.silver_1;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * Z
 */
public class _1074 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), r = nextInt(), c = nextInt();
    int length = (int) Math.pow(2, n), start = 0;
    while (r >= 2 || c >= 2) {
      start += length * length / 4 * ((r < length / 2 ? 0 : 2) + (c < length / 2 ? 0 : 1));
      length /= 2;
      r = r >= length ? r - length : r;
      c = c >= length ? c - length : c;
    }
    System.out.println(start + r * 2 + c);
  }
}

/*
time complexity
O(logN)

critical point
4덩어리로 계속 나눠가며 최종적으로 2x2 배열 생성, 시작점의 점수를 start 로 표현
length = 배열의 길이일 때
시작점의 점수는 누적해가며 행과 열 각각 length/2보다 같거나 큰 경우 r -= length/2, c -= length/2

n=3, r=7, c=7, length=8인 경우
1. start=8*8/4*3=48, r=7-8/2=3, c=7-8/2=3, length=4
2. start=48+4*4/4*3=60, r=3-4/2=1, c=3-4/2=1, length=2
3. r<2, c<2이므로 start+r*2+c=63

Z 형태로 숫자를 증가시켜야 하므로 행에 가중치를 두어야 함
(0,0) = 0 (0,1) = 1, (1,0) = 2, (1,1) = 3

reference
https://www.acmicpc.net/problem/1074
*/
