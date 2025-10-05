class SparseVector {
    List<int[]> pairs; //[index,value]

    SparseVector(int[] nums) {
        this.pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                pairs.add(new int[] { i, nums[i] });
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        int i = 0, j = 0;

        while (i < this.pairs.size() && j < vec.pairs.size()) {
            int idx1 = this.pairs.get(i)[0];
            int idx2 = vec.pairs.get(j)[0];

            //Indexes are the same 
            if (idx1 == idx2) {
                int value1 = this.pairs.get(i)[1];
                int value2 = vec.pairs.get(j)[1];
                result += value1 * value2;
                i++;
                j++;
            } else if (idx1 < idx2) {
                i++;
            } else {
                j++;
            }
        }

        return result;

    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);