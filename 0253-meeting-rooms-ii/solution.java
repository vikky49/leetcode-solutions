class Solution {
    public int minMeetingRooms(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        //Min heap to store the end times 

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // If earliest ending meeting has finished, reuse that room
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            //Add current meetings end time to the heap 
            pq.offer(end);

        }
        return pq.size();

    }
}
