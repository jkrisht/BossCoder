package curriculum.C9;

import java.util.Arrays;

public class RobotMoveUniqueWays {

    public static void main(String[] args) {
        System.out.println(new RobotMoveUniqueWays().uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        System.out.println(Arrays.deepToString(grid));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
            }
        }
        System.out.println(Arrays.deepToString(grid));

        return grid[m - 1][n - 1];
    }
}
