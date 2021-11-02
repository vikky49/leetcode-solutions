class Solution {
 public void solve(char[][] board) {
     
        if (board == null || board.length == 0)
            return;

        int row = board.length;
        int col = board[0].length;

        //merge O's on left & right boarder
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                merge(board, i, 0);
            }

            if (board[i][col - 1] == 'O') {
                merge(board, i, col - 1);
            }
        }

        //merge O's on top & bottom boarder
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                merge(board, 0, j);
            }

            if (board[row - 1][j] == 'O') {
                merge(board, row - 1, j);
            }
        }

        //process the board
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void merge(char[][] board, int i, int j) {
        board[i][j] = '#';

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && x < board.length
                    && y >= 0 && y < board[0].length
                    && board[x][y] == 'O') {
                merge(board, x, y);
            }
        }
    }
}
