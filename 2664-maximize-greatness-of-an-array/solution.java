class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);

        int res = 0;
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            if(nums[j] > nums[i]) {
               i++;
               res ++;
            }
            j++;
        }

        return res;
        
    }
}
