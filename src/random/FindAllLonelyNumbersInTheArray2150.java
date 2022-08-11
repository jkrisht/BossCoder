package random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllLonelyNumbersInTheArray2150 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 3};
        System.out.println(new FindAllLonelyNumbersInTheArray2150().findLonely(nums));
    }

    public List<Integer> findLonely(int[] nums) {
        List<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return list;
        }

        if (nums.length == 1) {
            list.add(nums[0]);
            return list;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            int dups = map.get(num);
            int currSum = map.getOrDefault(num + 1, 0);
            int currSub = map.getOrDefault(num - 1, 0);

            if (dups == 1 && currSum == 0 && currSub == 0) {
                list.add(num);
            }
        }

        return list;
    }
}
