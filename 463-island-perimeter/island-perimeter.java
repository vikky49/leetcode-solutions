class Solution {
    private int rows;
    private int cols;
    private static final int[][] DIRS = {
            { 0, 1 }, // right,
            { 1, 0 }, // Down
            { 0, -1 }, // Left
            { -1, 0 }
    };

    public int islandPerimeter(int[][] grid) {

        this.rows = grid.length;
        this.cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {

                    return dfs(grid, row, col, visited);
                }
            }
        }
        return 0;
    }

    private int dfs(
            int[][] grid,
            int row,
            int col,
            boolean[][] visited) {

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
            return 1; //Edge contributes to 1
        }

        if (visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;

        int perimeter = 0;

        for (int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            perimeter += dfs(grid, newRow, newCol, visited);
        }

        return perimeter;
    }
}