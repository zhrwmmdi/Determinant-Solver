package input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataHandler {
    private final Scanner reader;
    private int counter;
    File numbersFile;

    //Matrix matrix;
    public DataHandler(String filePath) throws FileNotFoundException {
        numbersFile = new File(filePath);
        reader = new Scanner(numbersFile);
        try{

            while (reader.hasNext()){
                counter++;
                reader.nextFloat();
            }
        }catch (Exception e){
            System.out.println(5);
            e.printStackTrace();
        }

    }

    public double[][] produceMatrix(){
        int size = (int)Math.sqrt(counter);
        if (counter%size != 0){
            System.err.println("Undefined");
            System.exit(0);
            return null;
        }else {
            double[][] matrix = new double[size][size];
            readAndStoreNumbers(matrix);
            return matrix;
        }
    }
    private void readAndStoreNumbers(double[][] matrix)   {

        try (Scanner reader = new Scanner(numbersFile)){
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (reader.hasNext()){
                        matrix[i][j] = reader.nextFloat();
                    }
                }
            }
        }catch (Exception ex){
            System.out.println("SOMETHING WENT WRONG IN input.DataHandler.readAndStoreNumbers() method.\n"+ex.getMessage());
        }
    }
    public void printMatrix(double[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }

    }

}
