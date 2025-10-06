class Solution {
    public boolean isStrobogrammatic(String num) {

        Map<Character, Character> rotatedDigits = Map.of(
                '0', '0',
                '1', '1',
                '6', '9',
                '8', '8',
                '9', '6');

        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);

            if (!rotatedDigits.containsKey(leftChar) ||
                    rotatedDigits.get(leftChar) != rightChar) {
                return false;
            }

            left++;
            right--;

        }

        return true;

    }
}