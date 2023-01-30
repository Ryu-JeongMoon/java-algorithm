package algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 단어의 개수
 */
public class _1152 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line = br.readLine().trim();
    if (line.isEmpty()) {
      System.out.println(0);
      return;
    }

    System.out.println(line.split(" ").length);
  }
}

/*
System.in.read() 원시 문자를 직접 읽어버리는 방식도 존재한다, 요게 젤 빠르다고 함
 */