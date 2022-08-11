package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InversionCount {
    public static void main(String[] args) {
        int[] arr = {10, 8, 4, 2, 1, 9};
        List<String> result = new ArrayList<>();
        inversionCount(arr, result);
        System.out.println("----------");
        System.out.println(result);
    }

    public static int[] inversionCount(int[] arr, List<String> result) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[mid];

        if (arr.length % 2 != 0) {
            right = new int[mid + 1];
        }

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        int[] leftArr = inversionCount(left, result);
        int[] rightArr = inversionCount(right, result);

        return mergeSort(leftArr, rightArr, result);
    }

    public static int[] mergeSort(int[] left, int[] right, List<String> res) {
        int[] result = new int[left.length + right.length];
        int l = 0, r = 0;
        for (int i = 0; i < result.length; i++) {
            if (l < left.length && r < right.length) {
                if (left[l] > right[r]) {
                    int index = l;
                    while (index < left.length) {
                        res.add(left[index++] + " - " + right[r]);
                    }
                    result[i] = right[r++];
                } else {
                    result[i] = left[l++];
                }
            } else if (l < left.length) {
                result[i] = left[l++];
            } else {
                result[i] = right[r++];
            }
        }

        System.out.println(Arrays.toString(result));

        return result;
    }
}
