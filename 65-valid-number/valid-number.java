class Solution {
    public boolean isNumber(String s) {
        s = s.trim();

        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDot = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                seenDigit = true;
            } else if (ch == '+' || ch == '-') {
                //Sign must be at a start or after e/e
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (ch == 'e' || ch == 'E') {
                //E requires digit before , cant have multiple e's
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false;
            } else if (ch == '.') {
                //cant have multiple dots or dot after e
                if (seenDot || seenExponent) {
                    return false;
                }

                seenDot = true;
            } else {
                return false;
            }

        }
        return seenDigit;

    }
}