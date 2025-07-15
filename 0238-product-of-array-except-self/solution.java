class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        //Step1: Calculate the left side of the things 
        result[0] = 1; 
        int i = 1; 
        // since we start with the left most we ignore the zeroth index as there is nothing before that number to Calculate
        while(i < n) {
            result[i] = result[i-1] * nums[i-1];
            i++; 
        }

        //Do the right product 
        int rightProduct = 1;
        i = n-1;
        while (i >= 0) {
            //First multiply the right numner 
            result[i] = result[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
            i--;
        }
        return result;
    }
}
