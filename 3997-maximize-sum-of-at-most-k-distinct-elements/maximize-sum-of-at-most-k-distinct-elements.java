class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Set<Integer> dedupeSet = new HashSet<>();
        for (int num : nums) {
            dedupeSet.add(num);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(dedupeSet);

        int size = Math.min(maxHeap.size(), k);
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = maxHeap.poll();
        }

        return result;

    }
}