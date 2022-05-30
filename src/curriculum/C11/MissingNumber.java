package curriculum.C11;

// https://leetcode.com/problems/missing-number/
public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(new MissingNumber().missingNumber(new int[]{1, 2, 3, 0}));
    }

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("No missing number");
        }

        if (nums.length == 1) {
            return nums[0] == 0 ? 1 : 0;
        }

        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }

        return res;
    }
}
