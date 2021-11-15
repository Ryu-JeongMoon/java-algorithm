package codetest;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Number2 {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 1, 4, 2, 1, 3};
        HashMap<Integer, Set<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], Set.of(i));
        }

        for (Integer integer : indexMap.keySet()) {
            System.out.print("integer = " + integer + " ");
            System.out.println("indexMap.get(integer) = " + indexMap.get(integer));
        }
    }

    public static int solution(int[] arr) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }

        int answer = -2;
        return answer;
    }
}
