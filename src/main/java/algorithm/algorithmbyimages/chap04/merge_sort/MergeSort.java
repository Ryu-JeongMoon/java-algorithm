package algorithm.algorithmbyimages.chap04.merge_sort;

import java.util.Arrays;

public class MergeSort {

    private static int[] src;
    private static int[] tmp;

    public static void main(String[] args) {
        src = new int[] {4,7,9,5,3,1,533,212,4,6,64,63};
        tmp = new int[src.length];
        System.out.println("Arrays.toString(src) = " + Arrays.toString(src));

        mergeSort(0, src.length-1);
        System.out.println("Arrays.toString(src) = " + Arrays.toString(src));
    }

    private static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);

            int p = start;
            int q = mid + 1;
            int idx = p;

            while (p <= mid || q <= end) {
                if (q > end || p <= mid && src[p] < src[q]) {
                    tmp[idx++] = src[p++];
                } else {
                    tmp[idx++] = src[q++];
                }
            }

            for (int i = start; i <= end; i++) {
                src[i] = tmp[i];
            }
        }
    }
}
