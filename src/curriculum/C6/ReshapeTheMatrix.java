package curriculum.C6;

import java.util.Arrays;

public class ReshapeTheMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        int r = 2, c = 4;
        System.out.println(Arrays.deepToString(new ReshapeTheMatrix().matrixReshape(matrix, r, c)));
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat == null || mat.length <= 0 || mat[0] == null || mat[0].length <= 0) {
            return mat;
        }

        int actCount = mat.length * mat[0].length;
        int givenCount = r * c;

        if (givenCount == actCount) {
            int[][] reshape = new int[r][c];

            int ri = 0, ci = 0;

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    if (ci < c) {
                        reshape[ri][ci++] = mat[i][j];
                    } else {
                        ri++;
                        ci = 0;
                        reshape[ri][ci++] = mat[i][j];
                    }
                }
            }

            return reshape;
        }

        return mat;
    }
}
