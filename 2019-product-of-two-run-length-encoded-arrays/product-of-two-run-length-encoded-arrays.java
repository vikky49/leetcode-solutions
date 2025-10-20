class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {

        int i = 0;
        int j = 0;

        // initiate frequencies for the first segment
        int freq1 = encoded1[0][1];
        int freq2 = encoded2[0][1];

        int lastProduct = -1;

        List<List<Integer>> result = new ArrayList<>();

        while (i < encoded1.length && j < encoded2.length) {

            int val1 = encoded1[i][0];
            int val2 = encoded2[j][0];

            int product = val1 * val2;

            int minFreq = Math.min(freq1, freq2);

            if (product == lastProduct) {
                List<Integer> last = result.get(result.size() - 1);
                last.set(1, last.get(1) + minFreq);
            } else {
                result.add(Arrays.asList(product, minFreq));
                lastProduct = product;
            }

            //Update the frequencies
            freq1 -= minFreq;
            freq2 -= minFreq;

            if (freq1 == 0) {
                i++;
                if (i < encoded1.length) {
                    freq1 = encoded1[i][1];
                }
            }

            if (freq2 == 0) {
                j++;
                if (j < encoded2.length) {
                    freq2 = encoded2[j][1];
                }
            }

        }

        return result;

    }
}