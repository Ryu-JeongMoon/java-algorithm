package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 귀걸이
 */
public class _1380 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int scenario = 1;
		while (true) {
			String line = br.readLine();
			if ("0".equals(line)) {
				System.out.print(sb);
				break;
			}

			int n = Integer.parseInt(line);
			String[] names = new String[n];
			for (int i = 0; i < n; i++) {
				names[i] = br.readLine();
			}

			boolean[] visited = new boolean[n];
			for (int i = 0; i < 2 * n - 1; i++) {
				int number = Integer.parseInt(br.readLine().split(" ")[0]) - 1;
				visited[number] = !visited[number];
			}

			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					sb.append(scenario++).append(" ").append(names[i]).append("\n");
					break;
				}
			}
		}
	}
}

/*
time complexity
매 입력마다 names 배열에 이름을 넣어주고 방문 여부를 2n-1번 체크해야 하므로 O(n)

critical point
index 0부터 시작하므로 입력 받은 여학생 번호에서 -1을 해준다

reference
https://www.acmicpc.net/problem/1380
 */
