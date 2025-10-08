class Solution {
    public int connectSticks(int[] sticks) {

        if (sticks.length <= 1) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int stick : sticks) {
            minHeap.offer(stick);
        }

        int totalCost = 0;

        while (minHeap.size() > 1) {
            int firstSmall = minHeap.poll();
            int secondSmall = minHeap.poll();

            int cost = firstSmall + secondSmall;
            totalCost += cost;
            minHeap.offer(cost);
        }

        return totalCost;

    }
}