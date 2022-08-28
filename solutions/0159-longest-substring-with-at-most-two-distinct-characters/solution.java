class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        Map<Character,Integer> map = new HashMap<>();
        
        while(right < s.length()) {
            
            map.put(s.charAt(right),right);
            
            if(map.size() == 3) {
               int smallIndex = Collections.min(map.values());
                map.remove(s.charAt(smallIndex));
                left = smallIndex + 1;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
            right ++;
                        
        }
        
        return maxLen;
        
    }
}
