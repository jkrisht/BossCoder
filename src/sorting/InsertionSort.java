package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {9, 7, 6, 8, 3, 4, 2, 1, 5};
        insertionSort(arr);
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int pos = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[pos] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[pos];
                    arr[pos] = temp;
                    pos--;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
