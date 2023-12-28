package procedure;

public class Laplace {
    private static double[][] subMatrix(double[][] matrix, int size, int row, int col) {
        double[][] sub = new double[size - 1][size - 1];
        int r = 0, c = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i != row) && (j != col)) {
                    sub[r][c] = matrix[i][j];
                    c++;
                    if (c == sub.length) {
                        c = 0;
                        r++;
                    }
                }
            }
        }
        return sub;
    }

    public static double laplace(double[][] matrix, int size) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        double det = 0;
        for (int j = 0; j < size; ++j) {
            double[][] sub = subMatrix(matrix, matrix.length, 0, j);
            det += Math.pow(-1, j) * matrix[0][j] * laplace(sub, sub.length);
        }
        return det;
    }

}
