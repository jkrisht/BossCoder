package curriculum.C6;

public class SumOfAllSubmatricesOfGivenMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}};
        System.out.println(new SumOfAllSubmatricesOfGivenMatrix().sumOfSubMatrices(matrix));
    }

    public int sumOfSubMatrices(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            throw new RuntimeException("Matrix is null / empty");
        }

        int sum = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i].length != matrix[0].length) {
                    throw new RuntimeException("Matrix is null / empty");
                }

                int topLeft = (i + 1) * (j + 1);
                int bottomLeft = (n - i) * (m - j);
                sum += (topLeft * bottomLeft) * matrix[i][j];
            }
        }

        return sum;
    }
}
