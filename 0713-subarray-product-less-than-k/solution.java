class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //Same thing related to sliding window
        //This is variable length sliding window

        //The pattern is Left and right pointers where the right pointer being the i that loops the nums and then
        // find the hard wall on the array where the sub-ordinate (Lazy manager approach) knows that the sub-array product
        //is K

        int globalAns = 0;
        int windowProd = 1;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            //Multiply the Window Prod
            windowProd = windowProd * nums[i];

            //The while loop

            while (left <= i && windowProd >= k) {
                windowProd = windowProd / nums[left];
                left++;
            }

            globalAns = globalAns + (i - left + 1);
        }
        return globalAns;

    }
}

