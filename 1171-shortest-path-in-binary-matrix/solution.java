class Solution {

    class Triple {
        int row;
        int col;
        int maxLength;

        Triple(int row, int col, int maxLength) {
            this.row = row;
            this.col = col;
            this.maxLength = maxLength;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        //If the start and the end are blocked 
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        //if the grid size is just 1
        if (n == 1) {
            return 1;
        }

        int[][] directions = {
                //row-1,col-1 , row-1,col, row-1,col+1
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                //row,col-1 row,col
                { 0, -1 }, { 0, 1 },
                //row+1,col-1 , row+1,col,   row+1,col+1
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        Queue<Triple> queue = new LinkedList<>();
        boolean[][] visted = new boolean[n][n];

        //start with the first 
        visted[0][0] = true;
        queue.offer(new Triple(0, 0, 1));

        while (!queue.isEmpty()) {
            Triple currentCell = queue.poll();
            int currentRow = currentCell.row;
            int currentCol = currentCell.col;
            int maxLength = currentCell.maxLength;

            for (int[] dir : directions) {
                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n
                        && grid[newRow][newCol] == 0 && !visted[newRow][newCol]) {

                    if (newRow == n - 1 && newCol == n - 1) {
                        return maxLength + 1;
                    }

                    visted[newRow][newCol] = true;
                    queue.offer(new Triple(newRow, newCol, maxLength + 1));

                }
            }

        }
        return -1;
    }
}
