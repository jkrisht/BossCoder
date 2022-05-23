package curriculum.C6;

// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
public class CountNegativeNumbersInSortedMatrix {
    public static void main(String[] args) {
        int[][] grid = {{4, 3, 2, 1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        System.out.println(new CountNegativeNumbersInSortedMatrix().countNegatives1(grid));
    }

    public int countNegatives1(int[][] grid) {
        int count = 0;

        if (grid == null || grid.length <= 0 || grid[0] == null || grid[0].length <= 0) {
            return count;
        }

        int x = grid.length, y = grid[0].length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {

                if (grid[i][j] < 0) {
                    count += grid[j].length;
                    continue;
                }

                if (grid[i][y - 1] > 0) {
                    continue;
                }

                int l = 0, r = y - 1;
                while (l <= r) {
                    int m = (l + r) / 2;

                    if (grid[i][m] < 0) {
                        r = m - 1;
                    } else {
                        r = m + 1;
                    }
                }

            }
        }

        return count;
    }

    public int countNegatives(int[][] grid) {
        int count = 0;

        if (grid == null || grid.length <= 0 || grid[0] == null || grid[0].length <= 0) {
            return count;
        }

        int m = grid.length - 1;
        int n = grid[0].length - 1;
        int i = 0, j = n;

        while (i <= m && j >= 0) {
            if (grid[i][0] < 0) {
                count += grid[i].length;
                i++;
                j = n;
                continue;
            }

            if (grid[i][j] < 0) {
                count++;
                j--;
            }

            if (j < 0 || grid[i][j] >= 0) {
                j = n;
                i++;
            }
        }

        return count;
    }
}
