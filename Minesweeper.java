public class Minesweeper {

    public static char[][] generateBoard(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] directions = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'M')
                    continue;

                int count = 0;

                for (int[] dir : directions) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];

                    // 🔴 Boundary check (critical)
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                        if (board[ni][nj] == 'M') {
                            count++;
                        }
                    }
                }

                board[i][j] = (char) (count + '0');
            }
        }

        return board;
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'E', 'E', 'E' },
                { 'E', 'M', 'E' },
                { 'E', 'E', 'E' }
        };

        char[][] result = generateBoard(board);

        for (char[] row : result) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}