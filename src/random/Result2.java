package random;

import java.util.ArrayList;
import java.util.List;

public class Result2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(1);

        System.out.println(largestCountValue(list));
    }

    public static int largestCountValue(List<Integer> a) {
        if (a == null || a.size() < 2) {
            return 0;
        }

        int[] arr = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            arr[i] = a.get(i);
        }

        int[] result = mergeSort(arr);

        return result.length / 2;
    }

    public static int[] mergeSort(int[] arr) {
        int mid = arr.length / 2;

        return arr;
    }
}
