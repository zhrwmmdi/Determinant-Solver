package procedure;

public class Rezaee {
    public static double omidRezaei(double[][] matrix) {
        if (matrix.length == 1) return matrix[0][0];
        else if (matrix.length == 2) return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);

        double M00 = calculateDetSubMatrix(matrix, 0, 0);
        double M0n = calculateDetSubMatrix(matrix, 0, matrix.length - 1);
        double Mn0 = calculateDetSubMatrix(matrix, matrix.length - 1, 0);
        double Mnn = calculateDetSubMatrix(matrix, matrix.length - 1, matrix.length - 1);

        double[][] subMatrix00 = subMatrix(matrix, matrix.length, 0, 0);
        double insideDet = calculateDetSubMatrix(subMatrix00, subMatrix00.length - 1, subMatrix00.length - 1);
        if (insideDet == 0) {
            return 1;
        }
        double[][] matrixOfSubDeterminants = {{M00, M0n}, {Mn0, Mnn}};
        return 1 / insideDet * omidRezaei(matrixOfSubDeterminants);
    }

    //This method eliminates the row and column that is given in the method signature in order to make a sub matrix for
    //calculating the determinant.
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

    private static double calculateDetSubMatrix(double[][] matrix, int row, int col) {
        double[][] sub = subMatrix(matrix, matrix.length, row, col);
        return omidRezaei(sub);
    }
}
