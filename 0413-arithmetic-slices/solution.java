class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        //Base case 
        if(nums.length < 3) {
            return 0;
        }

        int totalCount = 0;
        int left = 0;

        while(left <= nums.length - 3) {
            int right = left + 1;
            int diff =  nums[right] - nums[left];

            //expand the window
            while(right+1 < nums.length && 
                  nums[right +1] - nums[right] == diff) {
                   //Expand the window
                   right ++;
                  }

            //calculate the number of subarrays in the window (left,right)      

            int windowLength = right - left + 1;

            if(windowLength >=3) {
                //This is hte formula for the math
                // Summation = (n-2) * (n-1) / 2
                int subarrays = (windowLength - 2) * (windowLength - 1) / 2;
                totalCount += subarrays;
            }

            left = right;

        }
        return totalCount;
        
    }
}
