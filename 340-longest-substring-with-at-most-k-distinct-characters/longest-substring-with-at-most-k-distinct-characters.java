class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 | k == 0) {
            return 0;
        }

        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            

            //check the window size and shrink int

            while (map.size() > k) {
                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) -1) ;

                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
                
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
        
    }
}