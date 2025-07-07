class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int leftPointer = 0;
        int rightPointer = 0;

        int leftBound = s.length();
        int rightBound = t.length();

        while (leftPointer < leftBound && rightPointer < rightBound) {
            if(s.charAt(leftPointer) == t.charAt(rightPointer)) {
               leftPointer ++;
            }
            rightPointer++;
        }
        
        return leftPointer == leftBound;

    }
}
