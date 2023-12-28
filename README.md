# Matrix Determinant

This is an educational project that calculates the determinant of a n*n matrix with three methods;
1. [Laplace](https://www.statlect.com/matrix-algebra/Laplace-expansion-minors-cofactors-adjoints#:~:text=The%20Laplace%20expansion%20is%20a,its%20signed%20minors%2C%20called%20cofactors.) method
2. [Gauss elimination](https://math.berkeley.edu/~mgu/MA54/hw9sol.pdf) method
3. [Omid RezeeiFar](https://www.sciencedirect.com/science/article/abs/pii/S0096300306014974) method

(You can see details of each procedure by clicking on their names.)

## Packaging
There are two packages, input and procedures.

**input package** contains the DataHandler class which reads the data from a txt file and store them as the matrix
elements row by row. Then it will return a two-dimensional double array.

**procedure package** contains three classes, each of them for ways of determinant computing(that were listed previously.)

## Explanation of classes
Each class implements one of the procedures of determinant calculation with a static target method that is directly called
and some helper methods that are used in that target method.

### DataHandler.java
* Its `constructor` gets a file path in its method signature and reads file and counts the number of doubles
in it, this counter will be later used for calculating the size of matrix.
* `produceMatrix()` method creates a two-dimensional array and then calls the readAndStoreNumbers() method to fill
this array. It also recognizes if the input data are not proper for a square matrix n*n.
* `readAndStoreNumbers()` method reads data from file and stores each double in the two-dimensional array(matrix) row by row.
* `printMatrix()` method prints the data of the matrix in a readable way.

### Gauss.java
* `subMatrix()` method eliminates the first column and first row of the current matrix.
* `swapRows()` method is used when the [0][0] item in a matrix is 0. In this case, it will make trouble in calculation of 
determinant (returns 0 at any case). This method swaps the items in first and second row of the matrix (this doesn't make
any change to determinant calculation.)
* `makeUpperTriangular()` method converts the matrix to its upper-triangular equivalent. For more explanation about [upper-triangular 
matrix](https://mathworld.wolfram.com/UpperTriangularMatrix.html), click on its link.
* `gauss()` method is the target method of this class that is recursive.

### Laplace.java
* `subMatrix()` method eliminates the row and column that is given in the method signature in order to make a sub matrix for
calculating the determinant.
* `laplace()` method is the target method of this class that recursively calculates the determinant of sub matrixes to reach
the whole matrix determinant.

### Rezaee.java
* `subMatrix()` method eliminates the row and column that is given in the method signature in order to make a sub matrix for
calculating the determinant.
* `omidRezaee()` method is the target method that processes the third algorithm of determinant calculation that is a recursive
algorithm based on calculating the smaller parts of matrix.
* `calculateSubMatrixDet()` method creates a sub matrix with help of `subMatrix()` method and give it to the `omidRezaee()`
method to calculate it recursively.

### Main.java
* In main class, first we create a DataHandler object and give our input txt file path to it.
* Then store the result of the `produceMatrix()` method of this class in a two-dimensional array. (This is the produced matrix
of data that is on the txt file.)
* Now we can call any of our target methods and give our matrix (and its size) to them in order to calculate the determinant!
