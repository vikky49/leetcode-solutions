class Solution {
    public void rotate(int[][] matrix) {
        transposeMatrix(matrix);
        reverse(matrix);
    }

    private void transposeMatrix(int[][] matrix) {
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp; 
            }
        }
    }

    private void reverse(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }

    }
}