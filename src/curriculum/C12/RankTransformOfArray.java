package curriculum.C12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfArray {
    public static void main(String[] args) {
        int[] arr = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        System.out.println(Arrays.toString(new RankTransformOfArray().arrayRankTransform(arr)));
    }

    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }

        int[] temp = arr.clone();
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : temp) {
            map.putIfAbsent(num, map.size() + 1);
        }

        for (int i = 0; i < temp.length; i++) {
            temp[i] = map.get(arr[i]);
        }

        return temp;
    }
}
