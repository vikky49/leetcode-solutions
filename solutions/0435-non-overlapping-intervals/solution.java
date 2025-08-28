class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        //Sort based on the end timing
        Arrays.sort(intervals,(a,b) -> a[1] - b[1]);

        int count = 1;
        int[] current = intervals[0];

        for(int i = 0; i < intervals.length; i++) {
            int[] next = intervals[i];
            if(current[1] <= next[0]) {
                count ++;
                current = next;
            }
            //else there is overlap and we can skip
        }

        return intervals.length - count;
        
    }
}
