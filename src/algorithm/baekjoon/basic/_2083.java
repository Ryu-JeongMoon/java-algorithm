package algorithm.baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 럭비 클럽
 */
public class _2083 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder result = new StringBuilder();
    while (true) {
      String[] personalInfo = br.readLine().split(" ");
      String name = personalInfo[0];
      if (name.equals("#")) {
        System.out.println(result);
        break;
      }

      int age = Integer.parseInt(personalInfo[1]);
      int weight = Integer.parseInt(personalInfo[2]);

      if (age > 17 || weight >= 80) {
        result.append(name).append(" Senior\n");
      } else {
        result.append(name).append(" Junior\n");
      }
    }
  }
}

/*
나이가 17세보다 많거나, 몸무게가 80kg 이상이면 성인부이다. 그 밖에는 모두 청소년부이다.

Joe 16 34
Bill 18 65
Billy 17 65
Sam 17 85
# 0 0

Joe Junior
Bill Senior
Billy Junior
Sam Senior
 */
