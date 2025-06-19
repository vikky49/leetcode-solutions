class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> window = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;

        for (right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            //shrink the window and move the left pointer if needed
            while (window.contains(current)) {
                //remove it from the window
                char toBeRemoved = s.charAt(left);
                window.remove(toBeRemoved);
                left++;
            }

            window.add(current);
            maxLength = Math.max(maxLength, right - left + 1);

        }
        return maxLength;

    }
}
