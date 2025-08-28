class Solution {
    public int[][] merge(int[][] intervals) {
    
    //Sort by first 
    Arrays.sort(intervals,
               (a,b) -> Integer.compare(a[0], b[0]));

    List<int[]> result = new ArrayList<>();
    //Add the first interval 

    int[] currentInterval = intervals[0];
    result.add(currentInterval);

    for(int i=1; i < intervals.length; i++) {
        int currentEnd = currentInterval[1];
        int nextStart = intervals[i][0];
        int nextEnd = intervals[i][1];

        if(currentEnd >= nextStart) {

            currentInterval[1] = Math.max(currentEnd, nextEnd);

        } else {
            currentInterval = intervals[i];
            result.add(currentInterval);

        }

    }
     return result.toArray(new int[result.size()][]);
        
    }
}
