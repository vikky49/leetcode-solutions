
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        //If the totalsum is odd we cannot partition
        if (totalSum % 2 != 0) {
            return false;
        }

        int subSetSum = totalSum / 2;

        boolean[][] memo = new boolean[nums.length][subSetSum + 1];
        boolean[][] visited = new boolean[nums.length][subSetSum + 1];
        return backtrack(nums, 0, subSetSum, memo, visited);

    }

    private boolean backtrack(
            int[] nums,
            int index,
            int remaining,
            boolean[][] memo,
            boolean[][] visited

    ) {

        if (remaining == 0) {
            return true;
        }

        if (remaining < 0) {
            return false;
        }

        if (index >= nums.length) {
            return false;

        }

        if (visited[index][remaining]) {
            return memo[index][remaining];
        }

        visited[index][remaining] = true;

        boolean include = backtrack(nums, index + 1, remaining - nums[index], memo, visited);

        boolean exclude = backtrack(nums, index + 1, remaining, memo, visited);

        memo[index][remaining] = include || exclude;

        return memo[index][remaining];

    }
}