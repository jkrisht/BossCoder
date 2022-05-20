package curriculum.C6;

public class Search2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix = {{-5}};
        int target = 13;
        System.out.println(new Search2DMatrixII().ssearchMatrixFast(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int len = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            if (len != matrix[i].length) {
                throw new RuntimeException("Invalid matrix");
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean ssearchMatrixFast(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int i = 0;
        int j = matrix[i].length - 1;

        while (i <= matrix.length - 1 && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }

            if (target < matrix[i][j]) {
                j--;
            }

            if (target > matrix[i][j]) {
                i++;
            }
        }

        return false;
    }
}
