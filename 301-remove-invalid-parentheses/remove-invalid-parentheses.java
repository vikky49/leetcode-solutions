class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        if (s == null) {
            return result;
        }

        int[] minRemoval = calculateMinRemoval(s);
        int leftRemoval = minRemoval[0];
        int rightRemoval = minRemoval[1];

        Set<String> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        backtrack(
                s,
                0, leftRemoval, rightRemoval, 0, 0, result, visited, sb

        );

        return result;

    }

    private void backtrack(
            String s,
            int index,
            int leftRem,
            int rightRem,
            int open,
            int close,
            List<String> result,
            Set<String> visited,
            StringBuilder sb) {

        //Base Case

        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0 && open == close) {
                String candidate = sb.toString();
                if (!visited.contains(candidate)) {
                    result.add(candidate);
                    visited.add(candidate);
                }
            }
            return;
        }

        //BackTracking choices 

        //Remove Character 

        char c = s.charAt(index);

        //DECISION 1 : Remove current character if its paranthesis 

        if (c == '(' && leftRem > 0) {
            backtrack(
                    s, index + 1, leftRem - 1, rightRem, open, close, result, visited, sb);
        }

        //Remove ")"
        if (c == ')' && rightRem > 0) {
            backtrack(
                    s, index + 1, leftRem, rightRem - 1, open, close, result, visited, sb);
        }

        //DECISION 2 : KEEP THE CURRENT CHAR

        sb.append(c);

        if (c == '(') {
            //keeping this so we increment the left open counter
            backtrack(
                    s, index + 1, leftRem, rightRem, open + 1, close, result, visited, sb);
        } else if (c == ')') {
            if (open > close) {
                backtrack(
                        s, index + 1, leftRem, rightRem, open, close + 1, result, visited, sb);
            }
        } else {
            //Regular character
            backtrack(
                    s, index + 1, leftRem, rightRem, open, close, result, visited, sb);
        }

        sb.deleteCharAt(sb.length() - 1);

    }

    private int[] calculateMinRemoval(String s) {
        int left = 0;
        int right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        return new int[] { left, right };
    }
}