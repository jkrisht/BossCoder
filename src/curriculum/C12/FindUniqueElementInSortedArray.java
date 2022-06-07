package curriculum.C12;

import java.util.Arrays;

public class FindUniqueElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {2, 2, 21, 21, 33};
        System.out.println(Arrays.toString(findUniqueElement(arr)));
    }


    public static int[] findUniqueElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("Invalid array.");
        }

        if (arr.length == 1) {
            return new int[]{0, arr[0]};
        }

        if (arr.length % 2 == 0) {
            return new int[]{-1, Integer.MIN_VALUE};
        }

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;


        }

        return new int[]{-1, Integer.MIN_VALUE};
    }
}
