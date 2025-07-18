class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        if(edges.length != n-1) {
            return false;
        }
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return isConnectedBFS(graph, n);

    
    }

    private boolean isConnectedBFS(
        List<List<Integer>> graph,
        int n
    ) {
        if (n == 0) {
            return true;
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> neighbours = graph.get(node);

            for(int neighbour : neighbours) {
                if(!visited[neighbour]) {
                 visited[neighbour] = true;
                 queue.offer(neighbour);
                }
            }
        }

        //check if all the nodes are visited
        for(boolean v : visited) {
            if(!v) {
                return false;
            }
        }

        return true;
    }
}
