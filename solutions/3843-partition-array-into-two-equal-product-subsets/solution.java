class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        long totalProduct = 1;

        for(int num : nums) {
            totalProduct *= num;
        }

        if(totalProduct != (long) target * target) {
            return false;
        }

        return dfs(1, 1, target, 0, nums);
        
    }

    private boolean dfs(
        long first,
        long second,
        long target,
        int index,
        int[] nums
    ) {
         
         int n = nums.length;
        //Base case 
        if(first == target && second == target && index == n) {
            return true;
        }

        if(first > target || second > target || index ==n ) {
            return false;
        }

        return dfs(first * nums[index], second, target, index+1, nums) ||
               dfs(first, second * nums[index], target, index+1, nums);


    }
}
