class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //This is still a Sliding window problem where there is no fixed width
        //we calculate the window sum and move the window to the right as we move
        int left = 0;
        int globalAns = Integer.MAX_VALUE;
        int windowSum = 0;

        //Lets loop over the array where i or the right value here is the i

        for (int i = 0; i < nums.length; i++) {

            windowSum += nums[i];

            while (left <= i && windowSum >= target) {
                windowSum -= nums[left];
                //The new index is = i-left+1
                globalAns = Math.min(globalAns, i - left + 1);
                //Move the left pointer to the right of the array
                left++;
            }

        }

        if (globalAns == Integer.MAX_VALUE) {
            return 0;
        }
        return globalAns;
    }
}

