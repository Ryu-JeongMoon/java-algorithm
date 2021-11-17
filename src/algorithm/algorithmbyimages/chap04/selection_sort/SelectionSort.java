package algorithm.algorithmbyimages.chap04.selection_sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] list = {1, 5, 22, 3, 4, 214, 24, 53, 9};

        System.out.println("list = " + Arrays.toString(list));

        selectionSort(list);

        System.out.println("list = " + Arrays.toString(list));
    }

    private static void selectionSort(int[] list) {
        int indexMin, temp;

        for (int i = 0; i < list.length - 1; i++) {
            indexMin = i;

            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[indexMin]) {
                    indexMin = j;
                }
            }

            temp = list[indexMin];
            list[indexMin] = list[i];
            list[i] = temp;
        }
    }
}
