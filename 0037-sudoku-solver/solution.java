class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        initializeTracking(
                board,
                rows,
                cols,
                boxes);

        backtrack(
                board,
                rows,
                cols,
                boxes);

    }

    private void initializeTracking(
            char[][] board,
            boolean[][] rows,
            boolean[][] cols,
            boolean[][] boxes) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    char digit = board[row][col];
                    int digitIndex = digit - '1';
                    int boxIndex = (row / 3) * 3 + (col / 3);

                    rows[row][digitIndex] = true;
                    cols[col][digitIndex] = true;
                    boxes[boxIndex][digitIndex] = true;

                }
            }
        }

    }

    private boolean backtrack(
            char[][] board,
            boolean[][] rows,
            boolean[][] cols,
            boolean[][] boxes) {

        //Base case 
        int[] emptyCell = findNextEmptyChar(board);
        if (emptyCell == null) {
            return true; // No empty cells - puzzle solved!
        }

        int row = emptyCell[0];
        int col = emptyCell[1];
        int boxIndex = (row / 3) * 3 + (col / 3);

        for (char digit = '1'; digit <= '9'; digit++) {
            int digitIndex = digit - '1';

            if (!rows[row][digitIndex] &&
                    !cols[col][digitIndex] &&
                    !boxes[boxIndex][digitIndex]) {
                // not a valid choice 
                //Add to the slate 
                board[row][col] = digit;
                rows[row][digitIndex] = true;
                cols[col][digitIndex] = true;
                boxes[boxIndex][digitIndex] = true;

                //backtrack
                // 2. WORK (recurse to solve rest)
               if(backtrack(board, rows, cols, boxes)){
                return true;
               }

                //wipe the slate
                board[row][col] = '.';
                rows[row][digitIndex] = false;
                cols[col][digitIndex] = false;
                boxes[boxIndex][digitIndex] = false;

            }

        }
        return false;

    }

    private int[] findNextEmptyChar(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    return new int[] { row, col };
                }
            }
        }
        return null;

    }

}
