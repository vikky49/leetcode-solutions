
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

        Boolean[][] memo = new Boolean[nums.length][subSetSum + 1];
        return backtrack(nums, 0, subSetSum, memo);

    }

    private boolean backtrack(
            int[] nums,
            int index,
            int remaining,
            Boolean[][] memo

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

        if (memo[index][remaining] != null) {
            return memo[index][remaining];
        }

        boolean include = backtrack(nums, index + 1, remaining - nums[index], memo);

        boolean exclude = backtrack(nums, index + 1, remaining, memo);

        memo[index][remaining] = include || exclude;

        return memo[index][remaining];

    }
}