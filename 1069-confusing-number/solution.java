/* class Solution {
    public boolean confusingNumber(int n) {
         Map<Character,Character> invertMap = new HashMap<>() { 
            {
                put('0', '0');
                put('1', '1');
                put('6', '9');
                put('8', '8');
                put('9', '6');
            }
         };

         StringBuilder sb = new StringBuilder();

         for(char ch : String.valueOf(n).toCharArray()) {
            
            if(!invertMap.containsKey(ch)) {
                return false;
            }

            sb.append(invertMap.get(ch));

         }
         sb.reverse();

         return Integer.parseInt(sb.toString()) != n ;
        
    }
} */

class Solution {
    public boolean confusingNumber(int n) {
        Map<Integer,Integer> invertMap = new HashMap<>() {
            {
                put(0, 0);
                put(1, 1);
                put(6, 9);
                put(8, 8);
                put(9, 6);
            }
        };

        int nCopy = n; 
        int reversedNumber = 0;

        while (nCopy > 0) {
          int remainder = nCopy % 10;

          if(!invertMap.containsKey(remainder)) {
             return false;
          } 

          reversedNumber = (reversedNumber * 10) + invertMap.get(remainder);
          nCopy /= 10;       
            
        }

        return reversedNumber != n;
    }
}
