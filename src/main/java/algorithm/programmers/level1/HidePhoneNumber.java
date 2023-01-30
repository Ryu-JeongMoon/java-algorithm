package algorithm.programmers.level1;

import java.util.Arrays;

public class HidePhoneNumber {

    public static void main(String[] args) {
        System.out.println(solution("01033334444"));
    }

    public static String solution(String phone_number) {
        String lastFourDigit = phone_number.substring(phone_number.length() - 4);

        if (phone_number.length() == 4)
            return lastFourDigit;

        String asteriskString = Arrays.stream(phone_number.substring(0, phone_number.length() - 4).split("")).map(c -> "*")
            .reduce(String::concat).get();

        return asteriskString.concat(lastFourDigit);
    }
}
