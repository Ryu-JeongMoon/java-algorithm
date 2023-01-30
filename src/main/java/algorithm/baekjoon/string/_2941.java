package algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 크로아티아 알파벳
 */
public class _2941 {

  private static final Pattern[] CROATIAN_ALPHABETS = {
    Pattern.compile("c="),
    Pattern.compile("c-"),
    Pattern.compile("dz="),
    Pattern.compile("d-"),
    Pattern.compile("lj"),
    Pattern.compile("nj"),
    Pattern.compile("s="),
    Pattern.compile("z=")
  };

  public static void main(String[] args) throws IOException {
    String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
    int count = 0;
    for (Pattern pattern : CROATIAN_ALPHABETS) {
      Matcher matcher = pattern.matcher(line);
      while (matcher.find()) {
        line = matcher.replaceFirst("*");
        matcher = pattern.matcher(line);
        count++;
      }
    }

    String result = Pattern.compile("[*]").matcher(line).replaceAll("");
    System.out.println(count + result.length());
  }
}

/*
č   c=
ć	  c-
dž	dz=
đ	  d-
lj	lj
nj	nj
š	  s=
ž	  z=
 */