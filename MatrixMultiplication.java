public class MatrixMultiplication {

    public static int[][] multiply(int[][] A, int[][] B) {

        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;

        // Check validity
        if (n != B.length) {
            throw new IllegalArgumentException("Matrix multiplication not possible: cols of A != rows of B");
        }

        int[][] C = new int[m][p];

        // Core multiplication
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    public static void main(String[] args) {

        int[][] A = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        int[][] B = {
                { 7, 8 },
                { 9, 10 },
                { 11, 12 }
        };

        int[][] result = multiply(A, B);

        // print result
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}