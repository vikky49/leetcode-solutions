class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diag;
    private int antiDiag;
    private int n;

    public TicTacToe(int n) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
        this.diag = 0;
        this.antiDiag = 0;
    }

    public int move(int row, int col, int player) {

        // player 1 adds +1
        // player 2 adds -1

        int value = (player == 1) ? 1 : -1;

        rows[row] += value;

        cols[col] += value;

        //if row is col
        if (row == col) {
            diag += value;
        }

        if (row + col == n - 1) {
            antiDiag += value;
        }

        int target = value * n;
        if (rows[row] == target || cols[col] == target || diag == target || antiDiag == target) {
            return player;
        }

        //No winner yet
        return 0;

    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */