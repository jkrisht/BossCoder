package curriculum.C6;

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        int[][] matrix = {{5}};
        System.out.println(new MatrixDiagonalSum().diagonalSum(matrix));
    }

    public int diagonalSum(int[][] mat) {
        int sum = 0;

        if (mat == null || mat.length <= 0 || mat[0] == null || mat[0].length <= 0) {
            return sum;
        }

        if (mat.length != mat[0].length) {
            return sum;
        }

        int col = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][col++];
        }

        col = mat[0].length - 1;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][col--];
        }

        if (mat.length % 2 != 0) {
            sum -= mat[mat.length / 2][mat[0].length / 2];
        }

        return sum;
    }
}
