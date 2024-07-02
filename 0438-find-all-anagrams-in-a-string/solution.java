class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        //Edge base case
        if(p.length() > s.length()) {
            return List.of();
        }

        //Sliding window technique

        Map<Character,Integer> p_map = new HashMap<>();
        Map<Character,Integer> s_map = new HashMap<>();
        List<Integer> output = new ArrayList<>();

        int k = p.length();

        //Step 1 : Initialize the pmap

        for (int i = 0; i < p.length(); i++) {
            Character p_char = p.charAt(i);
            if (p_map.containsKey(p_char)) {
                int frequency = p_map.get(p_char);
                p_map.put(p_char, frequency + 1);
            } else {
                p_map.put(p_char, 1);
            }
        }

        //Initialize the first window

        for (int i = 0; i < k; i++) {
            Character s_char = s.charAt(i);
            if (s_map.containsKey(s_char)) {
                int frequency = s_map.get(s_char);
                s_map.put(s_char, frequency + 1);
            } else {
                s_map.put(s_char, 1);
            }
        }

        if(p_map.equals(s_map)) {
            output.add(0);
        }

        //Slide the window to the right
        //Remove the left most element and add the right most element

        for (int i = k; i < s.length(); i++) {
            Character leftElement = s.charAt(i - k);
            int frequency = s_map.get(leftElement) - 1;
            if (frequency == 0) {
                s_map.remove(leftElement);
            } else {
                s_map.put(leftElement, frequency);
            }
            
            //Now add the right element
            Character nextElement = s.charAt(i);
            if(s_map.containsKey(nextElement)){
                int freq = s_map.get(nextElement);
                s_map.put(nextElement, freq + 1);
            } else {
                s_map.put(nextElement, 1);
            }
            
            //Compare the maps and get the index
            if(s_map.equals(p_map)) {
                output.add(i - k + 1);
            }

        }
        return output;
        
    }
}
