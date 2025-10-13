class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        if (mat == null || mat.length == 0) {
            return new int[0];
        }
        //Total diagonals = rows + cols - 1

        int rows = mat.length;
        int cols = mat[0].length;
        int[] result = new int[rows * cols];
        int idx = 0;

        for (int d = 0; d < rows + cols - 1; d++) {
            if (d % 2 == 0) {
                // Going from bottom left to top right

                int row = Math.min(d, rows - 1);
                int col = d - row;

                while (row >= 0 && col < cols) {
                    result[idx++] = mat[row][col];
                    row--; // Move up
                    col++; //Move right
                }

            } else {
                // Going from top right to bottom left
                int col = Math.min(d, cols - 1);
                int row = d - col;

                while (col >= 0 && row < rows) {
                    result[idx++] = mat[row][col];
                    row++; //move down
                    col--; //move left
                }
            }

        }

        return result;

    }
}