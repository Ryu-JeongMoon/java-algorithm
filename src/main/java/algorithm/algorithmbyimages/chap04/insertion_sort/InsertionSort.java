package algorithm.algorithmbyimages.chap04.insertion_sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 2, 7, 8, 9};

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

        insertionSort(arr);

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int aux = i - 1;

            while (aux >= 0 && arr[aux] > temp) {
                arr[aux + 1] = arr[aux];
                aux--;
            }
            arr[aux + 1] = temp;
        }
    }
}
