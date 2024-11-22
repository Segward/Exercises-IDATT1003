
// This code demonstrates simple matrix operations in Java
public class MatrixOperations {

    // Matrix class with simple operations
    public static class Matrix {

        // The container has rows and columns representing the matrix
        private int[][] container;

        // Constructor with creation of matrix
        public Matrix(int rows, int cols) {
            this.container = new int[rows][cols];
        }

        // Constructor with a given matrix
        public Matrix(int[][] container) {
            this.container = container;
        }

        // Default constructor gives a 3x3 matrix
        public Matrix() {
            this.container = new int[3][3];
        }

        // Multiply the matrix with another matrix
        public Matrix Multiply(Matrix other) {
            int rowsA = this.container.length;
            int colsB = other.container[0].length;
            int colsA = this.container[0].length;

            // throw an exception if the matrices cannot be multiplied
            if (this.container[0].length != other.container.length) {
                throw new IllegalArgumentException("The matrices cannot be multiplied");
            }

            // Create a new matrix to store the result
            int[][] result = new int[rowsA][colsB];

            // Multiply the matrices
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsB; j++) {
                    // Calculate the element for the result matrix
                    for (int k = 0; k < colsA; k++) {
                        // Multiply elements of A and B and add to the result
                        result[i][j] += this.container[i][k] * other.container[k][j];
                    }
                }
            }

            // Explaination of the above code: 
            // i and j are the row and column of the result matrix
            // k is the column of the first matrix and row of the second matrix
            // result[i][j] is the element at row i and column j of the result matrix
            // this.container[i][k] is the element at row i and column k of the first matrix
            // other.container[k][j] is the element at row k and column j of the second matrix
            // k is inverted to iterate over the column of the second matrix and row of the first matrix

            // Return the result as a new matrix
            return new Matrix(result);
        }

        // Add the matrix with another matrix
        public Matrix Add(Matrix other) {

            // These should be the same for both matrices
            int rows = this.container.length;
            int cols = this.container[0].length;

            // throw an exception if the matrices are not of the same size
            if (this.container.length != other.container.length || this.container[0].length != other.container[0].length) {
                throw new IllegalArgumentException("The matrices are not of the same size");
            }

            // Create a new matrix to store the result
            int[][] result = new int[rows][cols];

            // Add the matrices
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = this.container[i][j] + other.container[i][j];
                }
            }

            // Return the result as a new matrix
            return new Matrix(result);
        }

        // Subtract the matrix with another matrix
        public Matrix Subtract(Matrix other) {

            // These should be the same for both matrices
            int rows = this.container.length;
            int cols = this.container[0].length;

            // throw an exception if the matrices are not of the same size
            if (this.container.length != other.container.length || this.container[0].length != other.container[0].length) {
                throw new IllegalArgumentException("The matrices are not of the same size");
            }

            // Create a new matrix to store the result
            int[][] result = new int[rows][cols];

            // Subtract the matrices
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = this.container[i][j] - other.container[i][j];
                }
            }

            // Return the result as a new matrix
            return new Matrix(result);
        }

        // Transpose the matrix
        public Matrix Transpose() {
            int rows = this.container.length;
            int cols = this.container[0].length;

            // Create a new matrix to store the result
            // This matrix will have the rows and columns inverted
            int[][] result = new int[cols][rows];

            // Transpose the matrix
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[j][i] = this.container[i][j];
                }
            }

            // Explaination of the above code:
            // Create a new matrix with the rows and columns inverted
            // Iterate over the rows and columns of the original matrix
            // Assign the element at row i and column j to the element at row j and column i of the new matrix

            // Return the result as a new matrix
            return new Matrix(result);
        }

        // Convert the matrix to a string
        public String toString() {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < this.container.length; i++) {
                for (int j = 0; j < this.container[0].length; j++) {
                    result.append(this.container[i][j] + ", ");
                }
                result.append("\n");
            }
            return result.toString();
        }

    }

    // Main method with test samples
    public static void main(String[] args) {
        try {
            // Add and subtract the matrices
            Matrix matrixA = new Matrix(new int[][] {{1, 2, 3},{4, 5, 6},{7, 8, 9}});
            Matrix matrixB = new Matrix(new int[][] {{1, 4, 3},{6, 5, 9},{7, 8, 3}});
            Matrix matrixC = matrixA.Add(matrixB);
            Matrix matrixD = matrixC.Subtract(matrixB);

            // Print the matrices
            System.out.println("\nMatrix addition and subtraction\n");
            System.out.println(matrixA.toString());
            System.out.println(matrixB.toString());
            System.out.println(matrixC.toString());
            System.out.println(matrixD.toString());

            // Multiply the matrices
            Matrix matrixE = new Matrix(new int[][] {{1, 4},{6, 5},{7, 3}}); // 3x2
            Matrix matrixF = new Matrix(new int[][] {{1, 4, 3},{6, 5, 9}}); // 2x3
            Matrix matrixG = matrixE.Multiply(matrixF);

            // Print the matrices
            System.out.println("\nMatrix multiplication\n");
            System.out.println(matrixE.toString());
            System.out.println(matrixF.toString());
            System.out.println(matrixG.toString());

            // Transpose the matrix
            Matrix matrixH = new Matrix(new int[][] {{8, 6},{4, 1}, {5, 5}}); // 3x2
            Matrix matrixI = matrixH.Transpose(); // should be 2x3

            // Print the matrices
            System.out.println("\nMatrix transpose\n");
            System.out.println(matrixH.toString());
            System.out.println(matrixI.toString());
        
        // Catch any thrown exceptions and print the message
        } catch (Exception IllegalArgumentException) {
            System.out.println(IllegalArgumentException.getMessage());
        }
    }
}