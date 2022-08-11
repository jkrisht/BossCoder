package dynamicprogramming;

import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrappingRainWater().trap(arr));
        System.out.println(new TrappingRainWater().trap1(arr));
    }

    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;
        // pre-compute
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0]; // init
        rightMax[n - 1] = height[n - 1];
        for (int i = 1, j = n - 2; i < n; ++i, --j) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }

        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));

        // water
        int totalWater = 0;
        for (int k = 1; k < n - 1; ++k) { // do not consider the first and the last places
            int water = Math.min(leftMax[k - 1], rightMax[k + 1]) - height[k];
            totalWater += Math.max(water, 0);
        }
        return totalWater;
    }

    public int trap1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height[0];
        right[n - 1] = height[n - 1];

        for (int i = 1, j = n - 2; i < n; i++, j--) {
            left[i] = Math.max(left[i - 1], height[i]);
            right[j] = Math.max(right[j + 1], height[j]);
        }

        int trappedWater = 0;

        for (int i = 1; i < n - 1; ++i) {
            int water = Math.min(left[i - 1], right[i + 1]) - height[i];
            trappedWater += Math.max(water, 0);
        }

        return trappedWater;
    }
}
