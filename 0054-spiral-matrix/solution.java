class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        while(top <= bottom && left <= right) {
          

          //left to right
          for(int j = left; j <= right; j++) {
            result.add(matrix[top][j]);
          }

          //increment top 
          top ++;

          //top right to right bottom
          for(int i = top; i <= bottom; i++) {
            result.add(matrix[i][right]);
          }

          right --;

          if(top <= bottom) {
            for (int j = right; j>= left; j--) {
                result.add(matrix[bottom][j]);
            }
            bottom --;
          }

          //back to top

          if(left <= right) {
            for(int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }

            left++;
          }


        }

        return result;
        
    }
}
