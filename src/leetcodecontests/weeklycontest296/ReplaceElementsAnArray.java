package leetcodecontests.weeklycontest296;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReplaceElementsAnArray {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        int[][] operations = {{1, 3}, {2, 1}, {3, 2}};
        System.out.println(Arrays.toString(new ReplaceElementsAnArray().smartArrayChange(nums, operations)));
    }

    public int[] smartArrayChange(int[] nums, int[][] operations) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int[] arr : operations) {
            int index = map.get(arr[0]);
            nums[index] = arr[1];
            map.put(arr[1], index);
        }

        return nums;
    }

    public int[] arrayChange(int[] nums, int[][] operations) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        for (int i = 0; i < operations.length; i++) {
            for (int k = 0; k < nums.length; k++) {
                if (operations[i][0] == nums[k]) {
                    nums[k] = operations[i][1];
                }
            }
        }

        return nums;
    }
}
