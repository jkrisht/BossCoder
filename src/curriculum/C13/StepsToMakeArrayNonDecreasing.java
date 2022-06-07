package curriculum.C13;

import java.util.Stack;

public class StepsToMakeArrayNonDecreasing {
    public static void main(String[] args) {
        int[] nums = {5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11};
        System.out.println(new StepsToMakeArrayNonDecreasing().totalSteps(nums));
    }

    public int totalSteps(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int count = 0;
        Stack<Integer> integers = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            integers.push(nums[i]);
        }

        System.out.println(integers.peek());

        return count;
    }
}
