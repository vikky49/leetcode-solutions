class Solution {
    public int findPairs(int[] nums, int k) {

        if (nums == null || nums.length < 2 || k < 0) {
            return 0;
        }

        Arrays.sort(nums);
        int left = 0;
        int right = 1;

        int pairsCount = 0;

        while (left < nums.length && right < nums.length) {

            if (left > 0 && nums[left] == nums[left - 1]) {
                left++;
                continue;
            }

            //Always ensure right above left 
            if (left >= right) {
                right = left + 1;
            }

            if(right >= nums.length) {
                break;
            }

            int diff = nums[right] - nums[left];
            if (diff < k) {
                right++;
            } else if (diff > k) {
                left++;
            } else {
                pairsCount++;
                left++;
                right++;
            }

        }

        return pairsCount;

    }
}