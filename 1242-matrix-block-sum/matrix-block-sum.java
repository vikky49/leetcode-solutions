class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] prefixSum = new int[rows + 1][cols + 1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                prefixSum[i + 1][j + 1] =
                        //left block       //Top block           //overlap
                        prefixSum[i + 1][j] + prefixSum[i][j + 1] - prefixSum[i][j] + mat[i][j];

            }
        }

        

        int[][] answer = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //calculate the block
                int r1 = Math.max(0, i - k); //// Top boundary (clamped to 0)
                int c1 = Math.max(0, j - k); //left boundary clamped to 0
                int r2 = Math.min(rows - 1, i + k); // Bottom boundary (clamped to rows-1)
                int c2 = Math.min(cols - 1, j + k); // Right boundary (clamped to cols-1)

                answer[i][j] = prefixSum[r2 + 1][c2 + 1]
                        - prefixSum[r2 + 1][c1]
                        - prefixSum[r1][c2 + 1]
                        + prefixSum[r1][c1];


                      /*

                               c1      c2+1
    r1   ┌────────┐
         │    -   │ Subtract top (prefixSum[r1][c2+1])
         │  +     │ Add back overlap (prefixSum[r1][c1])
  r2+1   │  TARGET│ Main rectangle (prefixSum[r2+1][c2+1])
         └────────┘
         └──┘
          - Subtract left (prefixSum[r2+1][c1])

                      */  

            }
        }

        return answer;

    }
}