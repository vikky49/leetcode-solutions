class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        //Edge case 
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int maxLength = 0;
        
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                maxLength = Math.max(maxLength, dfs(matrix,row,col,memo));
            }
        }
        
        return maxLength;
                
    }
    
    private int dfs(
        int[][] matrix,
        int row,
        int col,
        int[][] memo
    ) {
        
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        
        int maxLength = 1;
        
        int[][] directions = { {0,1} ,  //Right
                        {1,0} , //Down
                        {0,-1} , //left
                        {-1,0} //up
                      };
        
         for(int[] dir : directions ) {
             int newRow = row + dir[0];
             int newCol = col + dir[1];
             
             //Boundary checks 
             if(newRow >=0 && newRow < matrix.length && 
                newCol >=0 && newCol < matrix[0].length &&
               matrix[newRow][newCol] > matrix[row][col]) {
                 
                 maxLength = Math.max(maxLength, 1 + dfs(matrix,newRow,newCol,memo));
                 
             }
         }
        
        memo[row][col] = maxLength;
        return maxLength;
        
    }
}
