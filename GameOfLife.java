public class GameOfLife {

    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] directions = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        // Step 1: mark transitions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int liveNeighbors = 0;

                for (int[] d : directions) {
                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                        if (board[ni][nj] % 2 == 1) { // old state
                            liveNeighbors++;
                        }
                    }
                }

                // Apply rules
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 2; // alive → dead
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] = 3; // dead → alive
                    }
                }
            }
        }

        // Step 2: finalize states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] %= 2; // extract new state
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 }
        };

        gameOfLife(board);

        for (int[] row : board) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}