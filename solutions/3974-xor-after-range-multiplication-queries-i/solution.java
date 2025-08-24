class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int tenPower9 = 1_000_000_000 + 7 ;

        for(int[] query : queries) {
            int idx = query[0];
            int ri = query[1];
            int ki = query[2];
            int vi = query[3];

            while(idx <= ri) {
                 nums[idx] = (int)((1L * nums[idx] * vi) % tenPower9);
                 idx += ki;
            }
        }

        int result = 0;
        for(int num : nums) {
            result ^= num;
        }

        return result;
        
    }
}

