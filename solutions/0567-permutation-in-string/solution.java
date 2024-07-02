class Solution {
    public boolean checkInclusion(String s1, String s2) {

        //Edge case 
        if(s1.length() > s2.length()){
            return false;
        }
        //Sliding window technique 
        // 1. Initliaze the first step
        // 2. Fill the first window
        // 3. Slide the window and discard the left most element and add the right most element
        
        //Initialize the frequency for the String S1
        Map<Character, Integer> hmap_s1 = new HashMap<>();
        Map<Character, Integer> hmap = new HashMap<>();


        int k = s1.length();
        for (int i = 0; i < s1.length() ; i++) {
            Character character = s1.charAt(i);
            if (hmap_s1.containsKey(character)) {
                int frequency = hmap_s1.get(character);
                hmap_s1.put(character, frequency + 1);
            } else {
                hmap_s1.put(character, 1);
            }
        }

        //Fill the first window for S1
        for (int i = 0; i < k; i++) {
            Character s2char = s2.charAt(i);
            if (hmap.containsKey(s2char)) {
                int frequency = hmap.get(s2char);
                hmap.put(s2char, frequency + 1);
            } else {
                hmap.put(s2char, 1);
            }
        }
        //Here also we compare the hashmaps
         if(hmap_s1.equals(hmap)) {
             return true;
         }

         //Slide the window to the right
         // Here discard the left most element and add the right most element

        for(int i = k ; i < s2.length(); i++ ) {
            //This is the left most character. Eliminating it if the frequency is 0
            Character character = s2.charAt(i-k);
            int frequncy = hmap.get(character) - 1;
            if(frequncy == 0) {
                hmap.remove(character);
            } else {
                hmap.put(character,frequncy);
            }
            
            //Slide right and add the new elements
            Character ch = s2.charAt(i);
            if(hmap.containsKey(ch)){
                int frequency = hmap.get(ch);
                hmap.put(ch,frequency+1);
            } else {
                hmap.put(ch,1);
            }
            
            if(hmap_s1.equals(hmap)) {
                return true;
            }
        }
        
        return false;
    }
}
