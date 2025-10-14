class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] firstPos = new int[26];
        int[] lastPos = new int[26];

        Arrays.fill(firstPos, -1);

        for (int i = 0; i < s.length(); i++) {
            int charidx = s.charAt(i) - 'a';

            if (firstPos[charidx] == -1) {
                firstPos[charidx] = i;
            }

            //keep updating and the last one wins
            lastPos[charidx] = i;
        }

        //Create intervals for character that appears in the String
        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (firstPos[i] != -1) {
                intervals.add(new int[] { firstPos[i], lastPos[i] });
            }
        }

        //Sort the intervals by start position

        Collections.sort(intervals, (a, b) -> a[0] - b[0]);

        //Merge the overlapping intervals 
        List<Integer> result = new ArrayList<>();
        int start = intervals.get(0)[0];
        int end = intervals.get(0)[1];

        for (int i = 1; i < intervals.size(); i++) {
            int[] curr = intervals.get(i);

            if (curr[0] <= end) {
                //overlapping
                end = Math.max(end, curr[1]);

            } else {
                //Non overlapping
                result.add(end - start + 1);
                start = curr[0];
                end = curr[1];
            }
        }

        result.add(end - start + 1);
        return result;

    }

}