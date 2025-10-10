class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < A.length && j < B.length) {

            int low = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);

            if (low <= hi) {
                result.add(new int[] { low, hi });
            }

            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);

    }
}