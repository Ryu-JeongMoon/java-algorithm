package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 자전거 속도
 */
public class _2765 {

  public static final int INCH_TO_MILE = 12 * 5280;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String line, template = "Trip #%d: %.2f %.2f";
    int sequence = 1;
    float pi = 3.1415927f;

    // for submit
    // while ((line = br.readLine()) != null) {

    // for console
    while ((line = br.readLine()) != null && line.length() != 0) {
      String[] s = line.split(" ");
      float diameter = Float.parseFloat(s[0]);
      int rotationCount = Integer.parseInt(s[1]);
      if (rotationCount == 0) {
        continue;
      }

      float time = Float.parseFloat(s[2]);
      float distance = pi * diameter * rotationCount / INCH_TO_MILE;
      float roundedMilesPerHour = Math.round(distance / time * 3600 * 100);
      float roundedDistance = Math.round(pi * diameter * rotationCount / INCH_TO_MILE * 100);
      bw.write(String.format(template, sequence++, roundedDistance / 100, roundedMilesPerHour / 100) + "\n");
    }
    bw.flush();
    bw.close();
  }
}

/*
26 * 3.1415927 * 1000 / (12 * 5280)
한 바퀴 돌 때 = 2 * pi * 반지름
distance = pi * diameter * rotationCount / (12 * 5280)

diameter -> inch

time complexity
O(n)

critical point
1. 바퀴 둘레 => 2 * pi * 반지름 = pi * diameter
2. 이동거리  => distance = pi * diameter * rotationCount / (12 * 5280)
3. inch to mile => 12 * 5280

출력은 둘째자리까지 반올림해야 함
소수점 표현은 세 가지 방법 존재, 반올림은 1/2번만 가능
Math.round()가 성능 제일 좋음!!
1. Math.round()
2. NumberFormat
3. String.format()

1. Math.round()
Math.round(value * arg) / arg
arg = 1 * Math.pow(10, 반올림 자리 수)
둘째자리까지 반올림해야 한다면 Math.round(value, 100) / 100

2. NumberFormat
NumberFormat nf = NumberFormat.getNumberInstance();
nf.setMaximumFractionDigits(cutSize);
nf.setGroupingUsed(false);
return nf.format(value);

3. String.format()
String.format("%.2f", value);

reference
https://www.acmicpc.net/problem/2765
 */
