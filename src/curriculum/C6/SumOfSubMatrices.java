package curriculum.C6;

public class SumOfSubMatrices {
    // https://student.bosscoderacademy.com/user/curriculum/6
    // https://www.youtube.com/watch?v=trhm1IuqSdA

    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        System.out.println(sumOfSubMatrices(matrix));
    }

    public static int sumOfSubMatrices(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int result = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (matrix[i].length != m) {
                throw new RuntimeException("Invalid matrix / array for computation");
            }
            for (int j = 0; j < matrix[i].length; j++) {
                int topLeft = (i + 1) * (j + 1);
                int bottomRight = (n - i) * (m - j);
                int subMatrixCount = topLeft * bottomRight;
                result += subMatrixCount * matrix[i][j];
            }
        }

        return result;
    }
}
