class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        double MaxWindowSum = 0;
        double windowSum = 0;
        
        //get the first window sum and values are initiliazed
        for(int i=0; i< k; i++) {
            windowSum += nums[i];
        }
        
        MaxWindowSum = windowSum;
        
        // we keep sliding the array 
        // for each value from k to the end of the array
        
        for(int i=k; i< nums.length ; i++) {
            windowSum += nums[i] - nums[i-k];
            MaxWindowSum = Math.max(windowSum,MaxWindowSum);                        
        }
        
        //we would have the maxwindow sum by now 
        return MaxWindowSum / k;
        
    }
}
