
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double windowSum = 0;
        double maxSum = 0;

        for(int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        maxSum = windowSum;

        for(int i = k ; i < nums.length ; i++) {
            //add the current and remove the left most as we slide
            windowSum = windowSum + nums[i] - nums[i-k];
            maxSum = Math.max(windowSum, maxSum);
        }

        return maxSum/k;
        
    }
}
