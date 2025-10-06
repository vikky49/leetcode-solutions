class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {

            //check the element in the window
            if(window.contains(nums[i])){
                return true;
            }

            //Add the element to the window
            window.add(nums[i]);

            //check the kth element and update the window 
            if(window.size() > k) {
                window.remove(nums[i-k]);
            }

        }

        return false;
        
    }
}