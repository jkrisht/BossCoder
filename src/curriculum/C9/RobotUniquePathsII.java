package curriculum.C9;

import java.util.Arrays;

// https://leetcode.com/problems/unique-paths-ii/
public class RobotUniquePathsII {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0}, {1, 1}, {0, 0}};
        System.out.println(Arrays.deepToString(matrix));
        System.out.println();
        System.out.println(new RobotUniquePathsII().uniquePathsWithObstacles2(matrix));
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1 && obstacleGrid[0][0] == 0) {
            return 1;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] paths = new int[m][n];


        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                paths[i][0] = 0;
                break;
            } else {
                paths[i][0] = 1;
            }
        }
        System.out.println(Arrays.deepToString(paths));

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                paths[0][i] = 0;
                break;
            } else {
                paths[0][i] = 1;
            }
        }
        System.out.println(Arrays.deepToString(paths));

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                } else {
                    paths[i][j] = paths[i][j - 1] + paths[i - 1][j];
                }
            }
        }

        System.out.println(Arrays.deepToString(paths));

        return paths[m - 1][n - 1];
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1 && obstacleGrid[0][0] == 0) {
            return 1;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] != Integer.MAX_VALUE) {
                    if (i == 0 || j == 0) {
                        obstacleGrid[i][j] = 1;
                    } else {
                        obstacleGrid[i][j] = (obstacleGrid[i][j - 1] == Integer.MAX_VALUE ? 0 : obstacleGrid[i][j - 1]) + (obstacleGrid[i - 1][j] == Integer.MAX_VALUE ? 0 : obstacleGrid[i - 1][j]);
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(obstacleGrid));

        return obstacleGrid[m - 1][n - 1];
    }
}
