class Solution {
    public int orangesRotting(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();

        int freshCount = 0;

        for(int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    freshCount ++;
                } else if(grid[i][j] == 2) {
                   queue.offer(new Pair<Integer,Integer>(i, j));
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        int[][] directions = {
             {0,1}, // right
             {0,-1}, // left
             {1,0}, //up
             {-1,0} //down
        };

        int mins = 0;

        while(!queue.isEmpty() && freshCount > 0) {
           int size = queue.size();

           for(int i = 0; i < size; i++) {
           Pair<Integer,Integer> current = queue.poll();
           int row = current.getKey();
           int col = current.getValue();

           for(int[] dir: directions) {
             int newRow = row + dir[0];
             int newCol = col + dir[1];

             //do the check
             if(newRow >= 0 && newRow < rows 
               && newCol >= 0 && newCol < cols 
               && grid[newRow][newCol] == 1 ) {

                grid[newRow][newCol] = 2;
                freshCount --;
                queue.offer(new Pair<Integer,Integer>(newRow, newCol));

             }
             
            }
           }
           mins ++;

           
        }  
        return freshCount == 0 ? mins : -1;      
    }
}
