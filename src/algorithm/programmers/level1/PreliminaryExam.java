package algorithm.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class PreliminaryExam {

    public static void main(String[] args) {
        int[] firstWay = {1, 2, 3, 4, 5};

    }

    public static int[] solution(int[] answers) {

        List<Integer> result = new ArrayList<>();
        int[] firstWay = {1, 2, 3, 4, 5};
        int[] secondWay = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdWay = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int resultOfFirst = calculateCorrectAnswer(answers, firstWay);
        int resultOfSecond = calculateCorrectAnswer(answers, secondWay);
        int resultOfThird = calculateCorrectAnswer(answers, thirdWay);

        result.add(resultOfFirst);
        result.add(resultOfSecond);
        result.add(resultOfThird);

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static int[] solution2(int[] answers) {
        int[] result = {};
        int[] firstWay = {1, 2, 3, 4, 5};
        int[] secondWay = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdWay = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int countFirst = 0;
        int countSecond = 0;
        int countThird = 0;

        return result;
    }

    private static int calculateCorrectAnswer(int[] answers, int[] wayOfSolvingProblem) {

        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == wayOfSolvingProblem[i % 5]) {
                count++;
            }
        }
        return count;
    }
}
