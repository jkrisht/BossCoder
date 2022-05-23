package curriculum.C6;

import java.util.Arrays;

public class Convert1DArrayInto2DArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int m = 3, n = 1;
        System.out.println(Arrays.deepToString(new Convert1DArrayInto2DArray().construct2DArray(arr, m, n)));
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original == null || original.length <= 0 || m <= 0 || n <= 0) {
            return new int[0][0];
        }

        if (m * n == original.length) {
            int[][] reshape = new int[m][n];

            int mi = 0, ni = 0;
            for (int i = 0; i < original.length; i++) {
                if (ni < n) {
                    reshape[mi][ni++] = original[i];
                } else {
                    mi++;
                    ni = 0;
                    reshape[mi][ni++] = original[i];
                }
            }

            return reshape;
        }

        return new int[0][0];
    }
}
