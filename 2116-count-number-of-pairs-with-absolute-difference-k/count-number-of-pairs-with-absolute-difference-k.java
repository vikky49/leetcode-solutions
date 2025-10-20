class Solution {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num: nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int i=0;i<nums.length;i++)
        {
            int complement = nums[i] - k;
            if(map.containsKey(complement))
            {
                count = count + map.get(complement);
            }
        }

        return count;
    }
}