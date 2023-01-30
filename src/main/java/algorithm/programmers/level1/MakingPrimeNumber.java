package algorithm.programmers.level1;

public class MakingPrimeNumber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    int sum = nums[i] + nums[j] + nums[k];
                    int temp = 0;

                    for (int l = 2; l < sum; l++) {
                        if (sum % l == 0) {
                            temp++;
                            break;
                        }
                    }
                    if (temp == 0) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
