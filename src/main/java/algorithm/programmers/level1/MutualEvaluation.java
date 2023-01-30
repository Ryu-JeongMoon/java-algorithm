package algorithm.programmers.level1;

public class MutualEvaluation {

    public static void main(String[] args) {
        int[][] scores = {{50, 90}, {50, 87}};
        System.out.println(solution(scores));

        scores = new int[][]{{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65},
            {24, 90, 94, 75, 65}};
        System.out.println(solution(scores));

        scores = new int[][]{{70, 49, 90}, {68, 50, 38}, {73, 31, 100}};
        System.out.println(solution(scores));

    }

    public static String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < scores.length; i++) {
            int sum = 0;
            float averageScore = 0;
            int max = -1;
            int min = 101;
            int isUnique = 0;

            for (int j = 0; j < scores[0].length; j++) {
                max = Math.max(scores[j][i], max);
                min = Math.min(scores[j][i], min);
                sum += scores[j][i];

                if (j == i) {
                    continue;
                }

                isUnique = scores[i][i] != scores[j][i] ? isUnique : ++isUnique;
            }

            if ((scores[i][i] == max || scores[i][i] == min) && isUnique == 0) {
                sum -= scores[i][i];
                averageScore = sum / (scores.length - 1) * 1.0f;
            } else {
                averageScore = sum / scores.length * 1.0f;
            }

            calculateGrade(answer, averageScore);
        }
        return answer.toString();
    }

    private static void calculateGrade(StringBuilder answer, float averageScore) {
        if (averageScore >= 90) {
            answer.append("A");
        } else if (averageScore >= 80 && averageScore < 90) {
            answer.append("B");
        } else if (averageScore >= 70 && averageScore < 80) {
            answer.append("C");
        } else if (averageScore >= 50 && averageScore < 70) {
            answer.append("D");
        } else {
            answer.append("F");
        }
    }

    /**
     * calculateGrade 를 return averageScore >= 90 ? "A" : averageScore >= 80 ? "B" : averageScore >= 70 ? "C" : averageScore >= 50 ? "D" : "F";
     * 요렇게 풀 수도 있구나?!
     */

}
