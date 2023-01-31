package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 진짜 공간
 */
public class _1350 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] fileSizes = br.readLine().split(" ");
		int clusterSize = Integer.parseInt(br.readLine());
		long totalSize = 0;
		for (int i = 0; i < n; i++) {
			int fileSize = Integer.parseInt(fileSizes[i]);
			if (fileSize > clusterSize) {
				// 여기서 루프 태우면 시간 초과 발생
				if (fileSize % clusterSize != 0) {
					totalSize += (long) (fileSize / clusterSize + 1) * clusterSize;
				} else {
					totalSize += (long) (fileSize / clusterSize) * clusterSize;
				}
			} else if (fileSize > 0) {
				totalSize += clusterSize;
			}
		}
		System.out.println(totalSize);
	}
}

/*
time complexity
O(n)

critical point
클러스터는 오직 한 파일만 이용
무조건 반복 때리기 전에 나누어 계산할 수 있는지 확인할 것

reference
https://www.acmicpc.net/problem/1350
 */
