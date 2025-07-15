class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        for(int row = 0; row < rows; row++) {
            for (int col = 0; col < cols ; col++) {
                if(grid[row][col] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, row, col));
                }
            }
        }
        return maxArea;
        
    }

    private int dfs(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        //boundary check
        if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] !=1 ) {
            return 0;
        }

        int area = 1;
        grid[row][col] = 0;// Mark as visited
        
        area += dfs(grid, row+1, col); // goes Down
        area += dfs(grid, row-1, col);  // goes up
        area += dfs(grid, row, col + 1); //goes right 
        area += dfs(grid, row, col-1); //left
        
        return area;

    }
}
