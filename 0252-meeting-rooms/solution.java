class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        // lets sort this 

        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0], b[0]));

          // (a,b) (c,d) => b > c - then there is an overlap
        for(int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }
        return true;        
    }
}
