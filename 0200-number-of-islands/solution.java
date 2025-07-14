class Solution {
    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int numIslands = 0; 

        for(int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(grid[row][col] == '1'){
                   numIslands++;
                   dfs(grid,row,col);
                }
                
            }
        }
        return numIslands;        
    }

    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '0';
        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);
    }
}
