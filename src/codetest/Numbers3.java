package codetest;

public class Numbers3 {

    public static void main(String[] args) {
        System.out.println(solution("PM 11:50:05", 60 * 60 * 24 + 60));
    }

    public static String solution(String p, int n) {
        String[] splitTimeAndIndicator = p.split(" ");
        String[] splitTimeAndSeparator = splitTimeAndIndicator[1].split(":");

        if (splitTimeAndIndicator[0].equals("PM")) {
            splitTimeAndSeparator[0] = (Integer.parseInt(splitTimeAndSeparator[0]) + 12) % 24 + "";
        }

        int currentTime = 0;
        for (int i = 0; i < splitTimeAndSeparator.length; i++) {
            currentTime += Integer.parseInt(splitTimeAndSeparator[i]) * Math.pow(60, splitTimeAndSeparator.length - i - 1);
        }
        currentTime += n;

        int hour = currentTime / 3600 % 12;
        String hourString;
        if (hour < 10) {
            hourString = "0" + hour;
        } else {
            hourString = String.valueOf(hour);
        }

        int minute = currentTime % 3600;
        String minuteString;
        if (minute / 60 < 10) {
            minuteString = "0" + minute / 60;
        } else {
            minuteString = String.valueOf(minute / 60);
        }

        int second = currentTime % 60;
        String secondString = second >= 10 ? String.valueOf(second) : "0" + second;

        return String.join(":", hourString, minuteString, secondString);
    }
}
