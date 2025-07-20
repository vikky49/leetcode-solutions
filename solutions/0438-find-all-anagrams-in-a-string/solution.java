class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        //Edge cases 
        if(s == null || s.length() == 0 || 
           p == null || p.length() == 0 || 
           s.length() < p.length()) {
           
            return List.of();
        }

        List<Integer> result = new ArrayList<>();
        Map<Character,Integer> pfreqMap = new HashMap<>();
        Map<Character,Integer> windowFreq = new HashMap<>();

        for(char c: p.toCharArray()) {
            pfreqMap.put(c, pfreqMap.getOrDefault(c, 0)+1);
        }

        int left = 0; 
        int windowSize = p.length();

        for(int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowFreq.put(rightChar, windowFreq.getOrDefault(rightChar, 0) + 1);

            //check the window size now 
            //if the windowSize is greater === pop out the left char
            if(right - left + 1 > windowSize) {
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1 );

                //check the map and remove

                if(windowFreq.get(leftChar) == 0 ) {
                    windowFreq.remove(leftChar);
 
                }
                //adjust the window size
                left ++;
            }

            if(right -left + 1 == windowSize && windowFreq.equals(pfreqMap)) {
                result.add(left);
            }

        }

        return result;
        
    }
}
