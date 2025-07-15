class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int size = nums.length;
        int i = 0;

        while (i < size) {
            int start = nums[i];
            //check the consecutive values 

           //keep moving if they are in consecutive
            while(i < size-1 && nums[i] + 1 == nums[i+1]) {
                  i++;
            }

            if(start != nums[i]) {
                result.add(start + "->" + nums[i]);
            } else {
                result.add(String.valueOf(nums[i]));
            }
            i++;
        }

        return result;
        
    }
}
