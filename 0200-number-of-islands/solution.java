class Solution {
        
    private int m;
    private int n;
    private int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r,c});

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int[] dir : dirs) {
                int nR = curr[0] + dir[0];
                int nC = curr[1] + dir[1];

                if(0 <= nR && nR < m && 0 <= nC && nC < n && grid[nR][nC] == '1') {
                    //this is visited. so lets mark it 0
                    grid[nR][nC] = '0';
                    queue.offer(new int[]{nR,nC});
                }
            }
        }
       
    }

    public int numIslands(char[][] grid) {

        m = grid.length;
        n = grid[0].length;
        int num_of_islands = 0;

        for(int r = 0; r < m ; r++) {
            for(int c =0 ; c < n ; c++ ) {

              if(grid[r][c] == '1') {
                  num_of_islands ++;
                  bfs(grid,r,c);
              }

            }
        }
        return num_of_islands;
    }
}
