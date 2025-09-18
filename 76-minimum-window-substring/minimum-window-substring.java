class Solution {
    public String minWindow(String s, String t) {

        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        //Populate the targetMap
        Map<Character, Integer> targetMap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        //Initialize variables for sliding windows
        Map<Character, Integer> windowMap = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int minStart = 0;
        int required = targetMap.size();
        int formed = 0;

        while (right < s.length()) {

            char rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            //update the formed count 
            if (targetMap.containsKey(rightChar) &&
                    windowMap.get(rightChar).intValue() == targetMap.get(rightChar).intValue()) {
                formed++;
            }

            //check the formed count lenght and shrink the window

            while (left <= right && formed == required) {
                //remove the left and update the formed and move the window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;

                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.getOrDefault(leftChar, 0) - 1);

                if (targetMap.containsKey(leftChar) &&
                        windowMap.get(leftChar) < targetMap.get(leftChar)) {
                    formed--;
                }
                left++;
            }
            right++;

        }
        return minLength == Integer.MAX_VALUE ? ""
                : s.substring(minStart, minStart + minLength);

    }
}