package curriculum.C13;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 12;
        System.out.println(new Search2DMatrix().searchMatrix(matrix, target));
    }

    public boolean smartApproach(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)
                j--;
            else if (matrix[i][j] < target)
                i++;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0 || matrix[0] == null || matrix[0].length <= 0) {
            return false;
        }

        if (matrix.length == 1 && matrix[0].length == 1) {
            return matrix[0][0] == target;
        }

        int row = 0, col = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(i);
            if (matrix[i][col] == target) {
                return true;
            } else if (target < matrix[i][col]) {
                row = i;
                break;
            }
        }

        int start = 0, end = col;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
