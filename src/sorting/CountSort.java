package sorting;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {9, 7, 6, 8, 3, 4, 2, 1, 5, 100};
        countSort(arr);
    }

    public static void countSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        Map<Integer, Integer> integerMap = new TreeMap();
        for (int i = 0; i < arr.length; i++) {
            integerMap.put(arr[i], integerMap.getOrDefault(arr[i], 0) + 1);
        }

        int index = 0;
        for (Map.Entry<Integer, Integer> entry : integerMap.entrySet()) {
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                arr[index++] = entry.getKey();
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
