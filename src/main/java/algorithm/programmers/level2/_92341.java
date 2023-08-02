package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 주차 요금 계산
 */
public class _92341 {

  public static void main(String[] args) {
    _92341 instance = new _92341();
    System.out.println(Arrays.toString(instance.solution(
      new int[] { 180, 5000, 10, 600 },
      new String[] { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
        "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" })));

    System.out.println(Arrays.toString(instance.solution(
      new int[] { 120, 0, 60, 591 },
      new String[] { "16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN" })));

    System.out.println(Arrays.toString(instance.solution(
      new int[] { 1, 461, 1, 10 },
      new String[] { "00:00 1234 IN" })));

    System.out.println(Arrays.toString(instance.solution(
      new int[] { 180, 5000, 10, 1000 },
      new String[] { "05:59 0000 IN", "05:59 1111 IN" })));
  }

  public int[] solution(int[] fees, String[] records) {
    Map<String, Integer> timePerCar = new HashMap<>();
    Map<String, Integer> totalTimePerCar = new TreeMap<>();

    for (String record : records) {
      String[] tokens = record.split(" ");
      int minutes = toMinutes(tokens[0]);
      String carNumber = tokens[1];
      if ("IN".equals(tokens[2])) {
        timePerCar.put(carNumber, minutes);
      } else {
        totalTimePerCar.computeIfPresent(carNumber, (k, v) -> v + (minutes - timePerCar.get(carNumber)));
        totalTimePerCar.putIfAbsent(carNumber, minutes - timePerCar.get(carNumber));
        timePerCar.remove(carNumber);
      }
    }

    final int defaultOutTime = toMinutes("23:59");
    for (Map.Entry<String, Integer> entry : timePerCar.entrySet()) {
      totalTimePerCar.computeIfPresent(entry.getKey(), (k, v) -> v + (defaultOutTime - entry.getValue()));
      totalTimePerCar.putIfAbsent(entry.getKey(), defaultOutTime - entry.getValue());
    }

    int defaultParkingMinutes = fees[0];
    int defaultParkingFee = fees[1];
    int timeunitMinutes = fees[2];
    int timeunitFee = fees[3];

    return totalTimePerCar.values()
      .stream()
      .mapToInt(totalTime -> totalTime <= defaultParkingMinutes
        ? defaultParkingFee
        : defaultParkingFee + (int) (Math.ceil((double) (totalTime - defaultParkingMinutes) / timeunitMinutes)) * timeunitFee)
      .toArray();
  }

  private int toMinutes(String time) {
    String[] timeTokens = time.split(":");
    return Integer.parseInt(timeTokens[0]) * 60 + Integer.parseInt(timeTokens[1]);
  }
}

/*
time complexity
O(NlogN)

critical point
(int) (Math.ceil((double) (totalTime - defaultParkingMinutes) / timeunitMinutes)) * timeunitFee

int 유료주차시간 = totalTime - defaultParkingMinutes
int 단위시간횟수 = Math.ceil((double) 유료주차시간 / timeunitMinutes)
단위 시간 횟수에 단위 시간 요금을 곱해 총 주차 요금 계산

reference
https://programmers.co.kr/learn/courses/30/lessons/92341
*/
