import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DataHandler input = new DataHandler("matrix.txt");
        double[][] matrix = input.produceMatrix();

        double determinant = Rezaee.omidRezaei(matrix);
        System.out.println(determinant);

    }
}
