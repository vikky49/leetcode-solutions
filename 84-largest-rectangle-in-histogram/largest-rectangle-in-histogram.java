class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int heightIdx = stack.pop();
                int height = heights[heightIdx];

                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                int width = right - left - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int heightIdx = stack.pop();
            int height = heights[heightIdx];

            int left = stack.isEmpty() ? -1 : stack.peek();
            int right = heights.length;
            int width = right - left - 1;

            maxArea = Math.max(maxArea, height * width);

        }
        return maxArea;

    }
}