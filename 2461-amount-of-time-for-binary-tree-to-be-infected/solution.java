/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(root, null, graph);
        System.out.print(graph.toString());

        //Step2: BFS from start node to simulate infectious node 
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean infected = false;

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int neighbour : graph.getOrDefault(current, new ArrayList<>())) {
                    if (!visited.contains(neighbour)) {
                        visited.add(neighbour);
                        queue.offer(neighbour);
                        infected = true;
                    }
                }
            }

            if (infected) {
                time++;
            }
        }

        return time;

    }

    private void buildGraph(
            TreeNode node,
            TreeNode parent,
            Map<Integer, List<Integer>> graph) {
        if (node == null) {
            return;
        }

        graph.putIfAbsent(node.val, new ArrayList<>());

        if (parent != null) {
            graph.get(node.val).add(parent.val);
            graph.get(parent.val).add(node.val);
        }

        //Recursively build graph for children
        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }
}
