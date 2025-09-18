class Solution {
    public int myAtoi(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int sign = 1;
        long result = 0;

        //handle empty spaces 
        //Ignore the white spaces 
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i >= s.length())
            return 0;

        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        //Now calculate the actual 
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            //check the overflow logic 
            // Check for overflow before adding the digit
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return (int) (sign * result);
    }
}