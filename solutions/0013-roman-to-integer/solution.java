class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> romanToIntMap = Map.of(
            'I',1,
            'V',5,
            'X',10,
            'L',50,
            'C',100,
            'D',500,
            'M',1000
        );

        int sum = 0;
        int n = s.length();
        int i = 0;

        while (i < n) {
            int currentValue = romanToIntMap.get(s.charAt(i));
            //check if its subtaction case 
            if(i+1 < n && currentValue < romanToIntMap.get(s.charAt(i+1))) {
                int nextValue = romanToIntMap.get(s.charAt(i+1));
                sum += (nextValue-currentValue);
                //skip two steps here since we are moving 2 steps 
                i += 2;
            } else {
                // normal case 
                sum += currentValue;
                i++;
            }
            
        }
        return sum;
        
    }
}
