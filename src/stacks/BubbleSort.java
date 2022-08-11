package stacks;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 1, 3};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[mid];

        if (arr.length % 2 != 0) {
            right = new int[mid + 1];
        }

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        int[] leftArr = mergeSort(left);
        int[] rightArr = mergeSort(right);

        return merge(leftArr, rightArr);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int l = 0, r = 0;

        for (int i = 0; i < result.length; i++) {
            if (l < left.length && r < right.length) {
                if (left[l] < right[r]) {
                    result[i] = left[l++];
                } else {
                    result[i] = right[r++];
                }
            } else if (l < left.length) {
                result[i] = left[l++];
            } else if (r < right.length) {
                result[i] = right[r++];
            }
        }

        return result;
    }

}
