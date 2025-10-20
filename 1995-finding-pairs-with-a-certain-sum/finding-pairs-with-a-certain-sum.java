class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> freq2; // Frequency map for nums2
    
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.freq2 = new HashMap<>();
        
        // Build frequency map for nums2
        for (int num : nums2) {
            freq2.put(num, freq2.getOrDefault(num, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        // Remove old value from frequency map
        int oldVal = nums2[index];
        freq2.put(oldVal, freq2.get(oldVal) - 1);
        if (freq2.get(oldVal) == 0) {
            freq2.remove(oldVal);
        }
        
        // Add new value
        nums2[index] += val;
        int newVal = nums2[index];
        freq2.put(newVal, freq2.getOrDefault(newVal, 0) + 1);
    }
    
    public int count(int tot) {
        int result = 0;
        
        // For each num in nums1, find complement in nums2
        for (int num : nums1) {
            int complement = tot - num;
            result += freq2.getOrDefault(complement, 0);
        }
        
        return result;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */