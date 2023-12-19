package algorithm.solvedac.silver_1;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 팔
 */
public class _1105 {

  public static void main(String[] args) throws IOException {
    String lString = String.valueOf(nextInt()), rString = String.valueOf(nextInt());
    int minLength = lString.length(), maxLength = rString.length(), min = 0;
    if (minLength == maxLength) {
      for (int i = 0; i < minLength; i++) {
        if (lString.charAt(i) != rString.charAt(i)) {
          break;
        } else if (lString.charAt(i) == '8') {
          ++min;
        }
      }
    }
    System.out.println(min);
  }
}

/*
time complexity
O(n)

critical point
두 입력의 길이가 같은 경우, 고정점의 개수를 같은 자릿수의 값이 달라질 때까지 더해줌
8800, 8880은 88xx 까지는 무조건 8을 포함할 수 밖에 없기 때문에 고정점의 개수 2
3번째 자리수가 8이 아닐 때부터 뒤에 자리들은 8 외에 값을 가질 수 있으므로 탈출

reference
https://www.acmicpc.net/problem/1105
*/
