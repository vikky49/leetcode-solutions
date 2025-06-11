class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        //store the result
        int[] result = new int[n];

        //Lets calculate the left product first
        result[0] = 1;
        for(int i = 1; i < n ; i++) {
            result[i] = result[i-1] * nums[i-1];
        }

        //calculate the right product 
        int rightProduct = 1;
        for (int i = n-1; i >=0 ; i --) {
            result[i] = result[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }
        
        return result;
    }
}
