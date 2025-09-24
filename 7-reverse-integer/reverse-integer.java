class Solution {
    public int reverse(int x) {

        long rev = 0;
        int sign = x < 0 ? -1 : 1;
        int num = Math.abs(x);

        while (num > 0) {
            rev = rev * 10 + (num % 10);
            num = num / 10;
        }

        rev = rev * sign;

        if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) rev;

    }
}