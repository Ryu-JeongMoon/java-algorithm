package algorithm.programmers.level1;

public class Add2DArray {
    public static void main(String[] args) {
        int[][] arr1 = { { 1, 2 }, { 2, 3 } };
        int[][] arr2 = { { 3, 4 }, { 5, 6 } };
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        for (int i = 0; i < arr1.length; i++)
            for (int j = 0; j < arr1[0].length; j++)
                arr1[i][j] += arr2[i][j];

        return arr1;
    }
}
