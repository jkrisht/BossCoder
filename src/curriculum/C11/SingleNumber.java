package curriculum.C11;

// https://leetcode.com/problems/single-number/
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{2, 2, 1, 1}));
    }

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int res = 0;

        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}
