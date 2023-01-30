package algorithm.algorithmbyimages.chap04.etc;

public class AddOrMultiply {

    public static void main(String[] args) {
        System.out.println(addOrMultiply("02984"));
    }

    private static long addOrMultiply(String s) {
        String[] strings = s.split("");

        long result = Long.parseLong(strings[0]);

        for (String string : strings) {
            long i = Long.parseLong(string);

            if (i < 1 || result < 1) {
                result += i;
            } else {
                result *= i;
            }
        }

        return result;
    }
}
