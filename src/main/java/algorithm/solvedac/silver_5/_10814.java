package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 나이순 정렬
 */
public class _10814 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Member[] members = new Member[n];
    for (int i = 0; i < n; i++) {
      String[] line = br.readLine().split(" ");
      members[i] = new Member(Integer.parseInt(line[0]), line[1]);
    }
    Arrays.sort(members);
    for (Member member : members) {
      bw.write(member.age + " " + member.name + "\n");
    }

    br.close();
    bw.flush();
    bw.close();
  }

  private static class Member implements Comparable<Member> {

    private final int age;
    private final String name;

    public Member(int age, String name) {
      this.age = age;
      this.name = name;
    }

    @Override
    public int compareTo(Member o) {
      return this.age - o.age;
    }
  }
}

/*
time complexity
O(NlogN)

critical point

reference
https://www.acmicpc.net/problem/10814
*/
