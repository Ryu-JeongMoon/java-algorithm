package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팀 이름 정하기
 */
public class _1296 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String nameOfYeondoo = br.readLine();
    int numberOfL = getProbability(nameOfYeondoo, 'L');
    int numberOfO = getProbability(nameOfYeondoo, 'O');
    int numberOfV = getProbability(nameOfYeondoo, 'V');
    int numberOfE = getProbability(nameOfYeondoo, 'E');
    int n = Integer.parseInt(br.readLine()), max = Integer.MIN_VALUE;
    String winner = "";
    while (--n >= 0) {
      String team = br.readLine();
      int numberOfLInTeam = numberOfL + getProbability(team, 'L');
      int numberOfOInTeam = numberOfO + getProbability(team, 'O');
      int numberOfVInTeam = numberOfV + getProbability(team, 'V');
      int numberOfEInTeam = numberOfE + getProbability(team, 'E');
      int winningProbability = getWinningProbability(numberOfLInTeam, numberOfOInTeam, numberOfVInTeam, numberOfEInTeam);
      if (max < winningProbability || (max == winningProbability && winner.compareTo(team) > 0)) {
        max = winningProbability;
        winner = team;
      }
    }
    System.out.println(winner);
  }

  private static int getProbability(String name, char c) {
    int count = 0;
    for (int i = 0; i < name.length(); i++) {
      if (name.charAt(i) == c) {
        ++count;
      }
    }
    return count;
  }

  private static int getWinningProbability(int numberOfLInTeam, int numberOfOInTeam, int numberOfVInTeam, int numberOfEInTeam) {
    return ((numberOfLInTeam + numberOfOInTeam)
      * (numberOfLInTeam + numberOfVInTeam)
      * (numberOfLInTeam + numberOfEInTeam)
      * (numberOfOInTeam + numberOfVInTeam)
      * (numberOfOInTeam + numberOfEInTeam)
      * (numberOfVInTeam + numberOfEInTeam)) % 100;
  }
}

/*
time complexity
O(N)

critical point
초기 확률인 max를 0으로 두었을 경우, 전체 경우에서 확률이 모두 0이라면
빈 문자열이 다른 문자들보다 compareTo 앞서기 때문에 winner = ""로 출력되어 틀림
모든 경우의 확률이 0이 나올 것을 고려해 초기 확률을 Integer.MIN_VALUE 설정

reference
https://www.acmicpc.net/problem/1296
 */