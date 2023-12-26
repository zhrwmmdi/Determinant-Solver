import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DataHandler input = new DataHandler("matrix.txt");
        double[][] matrix = input.produceMatrix();

        double determinant = Gauss.gauss(matrix, matrix.length);
        System.out.println(determinant);

    }
}
