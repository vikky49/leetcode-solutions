class Solution {
    public int minAddToMakeValid(String s) {
        int openNeeded = 0;
        int closedNeeded = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                closedNeeded++;
            } else if (c == ')') {
                if (closedNeeded > 0) {
                    closedNeeded--;
                } else {
                    openNeeded++;
                }
            }
        }
        return openNeeded + closedNeeded;

    }
}