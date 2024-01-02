import input.DataHandler;
import procedure.Gauss;
import procedure.Laplace;
import procedure.Rezaee;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DataHandler input = new DataHandler("matrix.txt");
        double[][] matrix = input.produceMatrix();
        double determinant = Rezaee.omidRezaee(matrix);
        System.out.println("Det = "+determinant);
    }
}
