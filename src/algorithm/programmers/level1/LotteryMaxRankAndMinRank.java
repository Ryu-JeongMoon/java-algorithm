package algorithm.programmers.level1;

import java.util.function.IntFunction;

public class LotteryMaxRankAndMinRank {
    public static void main(String[] args) {
        int[] lottos = { 44, 1, 0, 0, 31, 25 };
        int[] win_nums = { 31, 10, 45, 1, 6, 19 };

        System.out.println(solution(lottos, win_nums));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int correct1 = 0;
        int correct2 = 0;
        int zeroNumber = 0;
        int inCorrect = 0;

        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == 0) {
                    zeroNumber++;
                    break;
                } else if (lottos[i] == win_nums[j]) {
                    correct1++;
                    break;
                }
            }
            if (correct1 == correct2)
                inCorrect++;

            correct2 = correct1;
        }

        answer[0] = getLotteryRank().apply(6 - inCorrect + zeroNumber);
        answer[1] = getLotteryRank().apply(correct1);

        return answer;
    }

    private static IntFunction<Integer> getLotteryRank() {
        IntFunction<Integer> rank = i -> {
            if (i == 1 || i == 0)
                i = 6;
            return 7 - i;
        };
        return rank;
    }
}

/**
 * 음.. 너무 막 풀었나, 변수명 좀 더 생각하고 풀자
 * 성능도 느리다 O(n^2)
 *
 * 성능을 생각하면 조금 더 원시적인 방법으로 명시적 반복
 * 세련된 방법으로 푸려면 람다, FP 공부!!
 */