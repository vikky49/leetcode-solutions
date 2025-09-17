class Solution {
    public boolean isValidSudoku(char[][] board) {
        //Track values 
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int i = 0 ; i < 9 ; i++ ) {
            for (int j = 0; j < 9; j++) {

                if(board[i][j] != '.') {
                    char digit = board[i][j];
                    int digitIndex = digit - '1';

                    int boxIndex = (i/3) * 3 + (j/3);

                    if(rows[i][digitIndex] || 
                      cols[j][digitIndex] ||
                      boxes[boxIndex][digitIndex]) {
                        return false;
                    }

                   rows[i][digitIndex] = true;
                   cols[j][digitIndex] = true;
                   boxes[boxIndex][digitIndex] = true; 

                }

            }
        }
        return true;
         
    }
}