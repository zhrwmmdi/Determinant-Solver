import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DataHandler input = new DataHandler("C:\\Users\\Hp\\Desktop\\test case project 3  DS\\0.txt");
        double[][] matrix = input.produceMatrix();

        double determinant = Rezaee.omidRezaei(matrix);
//        double determinant = Gauss.gauss(matrix, matrix.length);
//        double determinant = Laplace.laplace(matrix, matrix.length);

        System.out.println("Det = "+determinant);
    }
}
