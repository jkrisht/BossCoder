package curriculum.C6;

public class NumberofSubmatricesThatSumToTarget {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        System.out.println(new NumberofSubmatricesThatSumToTarget().numSubmatrixSumTarget(matrix, 0));
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;

        if (matrix == null || matrix.length <= 0 || matrix[0] == null || matrix[0].length <= 0) {
            return count;
        }

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                int topLeft = (i + 1) * (j + 1);
                int bottomRight = (matrix.length - i) * (matrix[i].length - j);
                sum = (topLeft * bottomRight * matrix[i][j]);
            }

            if (sum == target) {
                count++;
            }
        }

        return count;
    }
}
