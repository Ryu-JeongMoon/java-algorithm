package algorithm.programmers.level1;

public class CalculateNotEnoughFee {

    public static void main(String[] args) {
        long fee = solution(2500, 100000, 322);
        System.out.println("fee = " + fee);
        System.out.println(Math.abs(-129907500));
    }

    public static long solution(long price, long money, long count) {
        long answer = -1;

        answer = money - (price * count * (count + 1) / 2);

        if (answer >= 0)
            return 0;

        answer = Math.abs(answer);

        return answer;
    }
}

// 부족한 금액 계산하기
// 왜 틀린거지..
// parameter 를 long 형으로 받으면 테스트 통과됨
// 테스트 케이스 중 answer 를 int 형으로 바꿔버리는 게 있는건가?!