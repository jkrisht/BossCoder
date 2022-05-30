package curriculum.C9;

import java.util.Arrays;

// https://www.geeksforgeeks.org/subsequences-size-three-array-whose-sum-divisible-m/
public class SubsequencesOfSizeThreeInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3};
        System.out.println(efficientSolution(arr, 3));
    }

    public static int efficientSolution(int[] arr, int M) {
        int count = 0;

        if (arr == null || arr.length <= 2) {
            return count;
        }



        return count;
    }

    public static int bruteForce(int[] arr, int M) {
        if (arr == null || arr.length <= 2) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int sum = arr[i] + arr[j] + arr[k];

                    if (sum % M == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
