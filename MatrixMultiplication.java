import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input matrix A dimensions
        int n, m;
        System.out.print("Enter number of rows for Matrix A: ");
        n = getValidDimension(scanner);
        System.out.print("Enter number of columns for Matrix A (and rows for Matrix B): ");
        m = getValidDimension(scanner);

        // Input matrix B dimensions
        int p;
        System.out.print("Enter number of columns for Matrix B: ");
        p = getValidDimension(scanner);

        // Initialize matrices A, B and the resulting matrix C
        int[][] matrixA = new int[n][m];
        int[][] matrixB = new int[m][p];
        int[][] matrixC = new int[n][p];

        // Fill Matrix A
        System.out.println("Enter values for Matrix A:");
        fillMatrix(matrixA, n, m, scanner);

        // Fill Matrix B
        System.out.println("Enter values for Matrix B:");
        fillMatrix(matrixB, m, p, scanner);

        // Multiply matrices
        multiplyMatrices(matrixA, matrixB, matrixC, n, m, p);

        // Display result
        System.out.println("\nMatrix C (Result):");
        displayMatrix(matrixC, n, p);
    }

    // Get a valid dimension (positive integer) from the user
    private static int getValidDimension(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("\\d+") && Integer.parseInt(input) > 0) {
                return Integer.parseInt(input);
            }
            System.out.print("Invalid input. Enter a positive integer (with no spaces): ");
        }
    }

    // Fill a matrix with validated user input (only single integer per entry)
    private static void fillMatrix(int[][] matrix, int rows, int cols, Scanner scanner) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                while (true) {
                    System.out.print("Element at (" + (i + 1) + "," + (j + 1) + "): ");
                    String input = scanner.nextLine();
                    if (input.matches("-?\\d+")) { // Validate single integer input
                        matrix[i][j] = Integer.parseInt(input);
                        break;
                    } else {
                        System.out.println("Invalid input. Enter a single integer without spaces.");
                    }
                }
            }
        }
    }

    // Multiply two matrices A and B to get matrix C
    private static void multiplyMatrices(int[][] matrixA, int[][] matrixB, int[][] matrixC, int n, int m, int p) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                matrixC[i][j] = 0;
                for (int k = 0; k < m; k++) {
                    matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
    }

    // Display a matrix with formatted output
    private static void displayMatrix(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            System.out.print("| ");
            for (int j = 0; j < cols; j++) {
                System.out.printf("%4d ", matrix[i][j]);
            }
            System.out.println("|");
        }
    }
}
