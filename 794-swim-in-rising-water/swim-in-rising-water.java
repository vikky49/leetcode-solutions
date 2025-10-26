class Solution {
    //custom class for the cell 
    private static class Cell {
        int row;
        int col;
        int maxElevationOnpath;

        public Cell(
                int row,
                int col,
                int maxElevationOnpath) {
            this.row = row;
            this.col = col;
            this.maxElevationOnpath = maxElevationOnpath;
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> {
            return a.maxElevationOnpath - b.maxElevationOnpath;
        });

        int[][] dirs = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };

        pq.offer(new Cell(0, 0, grid[0][0]));

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            int currRow = cell.row;
            int currCol = cell.col;
            int currMaxElevationpath = cell.maxElevationOnpath;

            if (currRow == n - 1 && currCol == n - 1) {
                return currMaxElevationpath;
            }

            //skip if already visited
            if (visited[currRow][currCol]) {
                continue;
            }

            visited[currRow][currCol] = true;

            for (int[] dir : dirs) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];

                //check the bounds if not visited 
                if (newRow >= 0 && newRow < n &&
                        newCol >= 0 && newCol < n &&
                        !visited[newRow][newCol]) {

                    int newMaxElevation = Math.max(
                            currMaxElevationpath,
                            grid[newRow][newCol]);

                    pq.offer(new Cell(newRow, newCol, newMaxElevation));

                }
            }

        }

        return -1;

    }
}