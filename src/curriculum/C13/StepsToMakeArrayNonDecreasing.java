package curriculum.C13;

import java.util.Arrays;

// https://leetcode.com/problems/steps-to-make-array-non-decreasing/discuss/2085864/JavaC%2B%2BPython-Stack-%2B-DP-%2B-Explanation-%2B-Poem
public class StepsToMakeArrayNonDecreasing {
    public static void main(String[] args) {
        int[] nums = {5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11};
        System.out.println(new StepsToMakeArrayNonDecreasing().totalSteps(nums));
    }

    public int totalSteps(int[] A) {
        int n = A.length, res = 0, j = -1;
        int[] dp = new int[n], stack = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            while (j >= 0 && A[i] > A[stack[j]]) {
                dp[i] = Math.max(++dp[i], dp[stack[j--]]);
                res = Math.max(res, dp[i]);
            }
            stack[++j] = i;
        }
        System.out.println(Arrays.toString(stack));
        System.out.println(Arrays.toString(dp));
        return res;
    }
}
