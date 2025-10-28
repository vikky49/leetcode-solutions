class Solution {
    static final int[][] dirs = {
            { 0, 1 }, // right
            { -1, 0 }, //bottom
            { 0, -1 }, //Left
            { 1, 0 } // top
    };
    int rows, cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        this.rows = heights.length;
        this.cols = heights[0].length;

        boolean[][] atlantic = new boolean[rows][cols];
        boolean[][] pacific = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            //Left border - pacific
            //Right border - atlantic
            dfs(heights, pacific, row, 0);
            dfs(heights, atlantic, row, cols - 1);

        }

        for (int col = 0; col < cols; col++) {
            //Top border - pacific
            //bottom border - atlantic
            dfs(heights, pacific, 0, col);
            dfs(heights, atlantic, rows - 1, col);
        }

        //lets find the intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }

        return result;

    }

    private void dfs(
            int[][] heights,
            boolean[][] canReach,
            int row,
            int col) {

        canReach[row][col] = true;

        for (int[] dir : dirs) {
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;

            //check the boundaries

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                continue;
            }

            if (canReach[newRow][newCol]) {
                continue;
            }

            //Key condition --only if the water is above the level of the current it flows
            if (heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, canReach, newRow, newCol);
            }

        }

    }
}