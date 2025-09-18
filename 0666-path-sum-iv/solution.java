class Solution {
    private int totalSum = 0;
    private List<Integer> path = new ArrayList<>();

    public int pathSum(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> treeMap = new HashMap<>();
        //Build a treeMap 

        for (int num : nums) {
            char[] chars = String.valueOf(num).toCharArray();
            int level = chars[0] - '0';
            int position = chars[1] - '0';
            int value = chars[2] - '0';

            int key = level * 10 + position;

            treeMap.put(key, value);
        }

        dfs(treeMap, 1, 1);
        return totalSum;

    }

    private void dfs(
            Map<Integer, Integer> treeMap,
            int level,
            int pos) {

        int key = level * 10 + pos;

        if (!treeMap.containsKey(key)) {
            return;
        }

        //add to the path
        path.add(treeMap.get(key));

        int leftPos = pos * 2 - 1;
        int rightPos = pos * 2;

        int leftKey = (level + 1) * 10 + leftPos;
        int rightKey = (level + 1) * 10 + rightPos;

        //Check if its the leaf node 

        if (!treeMap.containsKey(leftKey) && !treeMap.containsKey(rightKey)) {
            // this is leafNode 
            long sum = 0;
            for (int i = 0; i < path.size(); i++) {
                sum += path.get(i);
            }
            totalSum += sum;
        } else {

            if (treeMap.containsKey(leftKey)) {
                dfs(treeMap, level + 1, leftPos);
            }

            if (treeMap.containsKey(rightKey)) {
                dfs(treeMap, level + 1, rightPos);
            }

        }

        //backtrack
        path.removeLast();

    }
}
