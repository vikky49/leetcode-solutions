class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 ||
                obstacleGrid[0][0] == 1) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        Integer[][] memo = new Integer[rows][cols];

        return dfs(obstacleGrid, 0, 0, rows, cols, memo);

    }

    private int dfs(
            int[][] grid,
            int row,
            int col,
            int m,
            int n,
            Integer[][] memo) {
        // Out of bounds or hit an obstacle
        if (row >= m || col >= n || grid[row][col] == 1) {
            return 0;
        }

        // Reached destination
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        // Return cached result if already computed
        if (memo[row][col] != null) {
            return memo[row][col];
        }

        // Explore right and down
        int right = dfs(grid, row, col + 1, m, n, memo);
        int down = dfs(grid, row + 1, col, m, n, memo);

        // Store result in memo and return
        memo[row][col] = right + down;
        return memo[row][col];
    }
}