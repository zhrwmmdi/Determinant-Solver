package procedure;

public class Gauss {
    public static double gauss(double[][] matrix, int size) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        if (matrix[0][0] == 0) {
            swapRows(matrix, size);
        }
        makeUpperTriangular(matrix, matrix.length);
        double[][] subMatrix = subMatrix(matrix, matrix.length);
        double det = gauss(subMatrix, subMatrix.length);
        return  ((matrix[0][0] * det) == -0.0) ? 0.0 : (matrix[0][0] * det);
    }


    private static double[][] subMatrix(double[][] matrix, int length){
        double[][] sub = new double[length-1][length -1];
        for (int i = 0; i < sub.length; i++) {
            for (int j = 0; j < sub.length; j++) {
                sub[i][j] = matrix[i+1][j+1];
            }
        }
        return sub;
    }

    private static void swapRows(double[][] matrix, int length) {
        int row = 1;
        //If the second row also starts with 0, we will continue until we reach a row that doesn't start with 0
        while ((row < length) && matrix[row][0] == 0) {
            row += 1;
        }
        if (row < length){
            for (int j = 0; j < length; j++) {
                double temp = matrix[0][j];
                matrix[0][j] = matrix[row][j];
                matrix[row][j] = temp;
            }
        }
    }

    private static void makeUpperTriangular(double[][] matrix, int length) {
        for (int row = 1; row < length; row++) {
            if (matrix[row][0] != 0) {
                double n = matrix[row][0] / matrix[0][0];
                for (int column = 0; column < length; column++) {
                    matrix[row][column] -= n * matrix[0][column];
                }
            }
        }
    }
}



