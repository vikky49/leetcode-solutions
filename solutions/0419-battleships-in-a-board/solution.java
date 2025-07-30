class Solution {
    public int countBattleships(char[][] board) {
        
        if(board == null || board[0].length == 0) {
            return 0;
        }

        int count = 0;

        for(int i=0 ; i < board.length; i++) {

            for(int j = 0; j < board[0].length; j++) {

                if(board[i][j] == 'X') {
                    dfs(board,i,j);
                    count ++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] board, int i, int j) {
        //base case

        if(i <0 || i >= board.length ||
           j < 0 || j >= board[0].length ||
           board[i][j] != 'X') {
            return;
        }

        board[i][j] = '.';

        //Explore 4 directions

        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);

    }
}
