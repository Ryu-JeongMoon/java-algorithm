package algorithm.programmers.level1;

public class MakingPrimeNumber {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(solution(nums));
    }

    // break 걸어주는 것만으로도 시간 단축 많이 됨!
    // stream 으로 해결하는 방법이 있을까?
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
                    if (temp == 0)
                        answer++;
                }
            }
        }

        return answer;
    }
}
