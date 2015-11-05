package by.epam.matrixmultiply;

/**
 * Created by Yahor_Faliazhynski on 11/3/2015.
 */
public class matrixMultiply {

    int[][] binaryMatrixOne = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    int[][] binaryMatrixTwo = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};

    public static void main(String[] args) {

        matrixMultiply instanceMatrix = new matrixMultiply();
        int[][] resultMatrix = matrixMultiplicator(instanceMatrix.binaryMatrixOne, instanceMatrix.binaryMatrixTwo);

        System.out.println("Multiplication result matrix:");

        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++)
                System.out.print(resultMatrix[i][j] + " "); //columns
            System.out.println(); //next row
        }
    }
    // Static method or function for matrix multiplication
    public static int[][] matrixMultiplicator (int[][] MatrixOne, int[][] MatrixTwo) {

        int matrixOneRows = MatrixOne.length;
        int matrixOneColumns = MatrixOne[0].length;
        int matrixTwoRows = MatrixTwo.length;
        int matrixTwoColumns = MatrixTwo[0].length;

        //Processing of possible multiplication exception when first matrix columns quantity not equal second matrix rows quantity. Otherwise, binary matrixes multiplication cannot be done
        if (matrixOneColumns != matrixTwoRows) {
            throw new IllegalArgumentException("First matrix columns quantity (" + matrixOneColumns + ") " + "isn't equal to second matrix rows (" + matrixTwoRows + "). Cannot multiply!");
        }

        //Filling by 0 of resulting matrix
        int[][] multiplyResult = new int[matrixOneRows][matrixTwoColumns];
        for (int i = 0; i < matrixOneRows; i++) {
            for (int j = 0; j < matrixTwoColumns; j++) {
                multiplyResult[i][j] = 0;
            }
        }

        //Matrixes multiplication itself
        for (int i = 0; i < matrixOneRows; i++) { // First matrix rows count
            for (int j = 0; j < matrixTwoColumns; j++) { // Second matrix columns count
                for (int k = 0; k < matrixOneColumns; k++) { // First matrix columns count
                    multiplyResult[i][j] += MatrixOne[i][k] * MatrixTwo[k][j];
                }
            }
        }
        return multiplyResult;
    }

}
