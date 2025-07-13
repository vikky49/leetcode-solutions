class Solution {
    public boolean exist(char[][] board, String word) {
         
         int rows = board.length;
         int cols = board[0].length;

         for(int row = 0; row < rows; row ++) {
            for (int col= 0; col < cols; col++ ) {
                if(dfs(board,word,row, col,0)) {
                    return true;
                }                
            }
         }
         return false;
                 
    }

    boolean dfs(
        char[][] board,
        String word,
        int row,
        int col,
        int index
    ) {
       
       //Base case 
       if(index == word.length()) {
         return true;
       }
       //check the boundaries 
       if(row < 0 || row >= board.length ||
          col <0  || col >= board[0].length ||
          board[row][col] != word.charAt(index)) {
            return false;
        }

        //Mark the current" board item 
        char temp = board[row][col];
        board[row][col] = '#';

        boolean doesExist = 
                    //up 
                    dfs(board,word,row-1,col,index+1) ||
                    //down
                    dfs(board,word,row+1,col,index+1) ||
                    //left
                    dfs(board, word, row, col-1, index+1) ||
                    //right
                    dfs(board, word, row, col+ 1, index+1);

       //restore the state
       board[row][col] = temp;

       return doesExist;

    }
}
