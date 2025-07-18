class Solution {
    public int countComponents(int n, int[][] edges) {
        
        //First build the graph 
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            //add edges 
            graph.get(edge[0]).add(edge[1]);
            //For undirected graph
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for(int i = 0; i < n ; i++) {
            if(!visited[i]) {
                bfs(graph, visited, i);
                components++;
            }
        }

      return components;
        
    }

    private void bfs(
        List<List<Integer>> graph,
        boolean[] visited,
        int start
    ) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        visited[start] = true;
        while (!queue.isEmpty()) {
            
            int node = queue.poll();
            List<Integer> neighbours = graph.get(node);
            for(int neighbour : neighbours ) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
    }
}
