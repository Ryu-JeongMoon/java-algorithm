package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 너의 평점은
 */
public class _25206 {

  private static final String PASS = "P";
  private static final Map<String, Float> GRADE_MAP = Map.of(
    "A+", 4.5f,
    "A0", 4.0f,
    "B+", 3.5f,
    "B0", 3.0f,
    "C+", 2.5f,
    "C0", 2.0f,
    "D+", 1.5f,
    "D0", 1.0f,
    "F", 0.0f
  );

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    float grade = 0, score = 0;
    for (int i = 0; i < 20; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      st.nextToken();
      float currentGrade = Float.parseFloat(st.nextToken());
      String currentScore = st.nextToken();
      if (currentScore.equals(PASS)) {
        continue;
      }

      score += (currentGrade * GRADE_MAP.get(currentScore));
      grade += currentGrade;
    }
    System.out.println(score / grade);
  }
}

/*
time complexity
O(1)

critical point

reference
https://www.acmicpc.net/problem/25206
*/
