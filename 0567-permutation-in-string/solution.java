class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        //update the s1 freq
        Map<Character, Integer> s1_Freq = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            s1_Freq.put(ch, s1_Freq.getOrDefault(ch, 0) + 1);
        }

        int windowSize = s1.length();
        int left = 0;

        Map<Character, Integer> window = new HashMap<>();

        for (int right = 0; right < s2.length(); right++) {

            char rightChar = s2.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            //check the window size and discard the left side of the window

            if (right - left + 1 > windowSize) {
                char leftChar = s2.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                //if the char frequency is 0 we delete int
                if (window.get(leftChar) == 0) {
                    window.remove(leftChar);
                }
                left++;
            }

            if (right - left + 1 == windowSize && s1_Freq.equals(window)) {
                return true;
            }

        }

        return false;

    }
}
