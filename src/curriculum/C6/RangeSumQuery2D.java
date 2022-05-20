package curriculum.C6;

import java.util.Arrays;

public class RangeSumQuery2D {

    public static void main(String[] args) {
        RangeSumQuery2D rangeSumQuery2D = new RangeSumQuery2D();
        rangeSumQuery2D.main();
    }

    public void main() {
        // int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        int[][] matrix = {{-4, -5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(0,0,0,0));
    }

    class NumMatrix {
        int[][] sumMatrix;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length + 1;
            int n = matrix[0].length + 1;

            sumMatrix = new int[m][n];

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    sumMatrix[i][j] = matrix[i - 1][j - 1] + sumMatrix[i][j - 1] + sumMatrix[i - 1][j] - sumMatrix[i - 1][j - 1];
                }
            }

            for (int i = 0; i < sumMatrix.length; i++) {
                System.out.println(Arrays.toString(sumMatrix[i]));
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;

            sum += sumMatrix[row2 + 1][col2 + 1];
            sum -= sumMatrix[row1][col2 + 1];
            sum -= sumMatrix[row2 + 1][col1];
            sum += sumMatrix[row1][col1];

            return sum;
        }
    }
}