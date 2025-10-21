class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> set = new HashSet<>(Arrays.asList(bank));

        Queue<String> queue = new LinkedList<>();
        int mutation = 0;

        if (!set.contains(endGene)) {
            return -1;
        }

        queue.offer(startGene);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String gene = queue.poll();

                if (gene.equals(endGene)) {
                    return mutation;
                }

                char[] geneChar = gene.toCharArray();

                for (int j = 0; j < 8; j++) {

                    char[] geneChoice = new char[] { 'A', 'C', 'G', 'T' };
                    char old = geneChar[j];

                    for (char c : geneChoice) {
                        geneChar[j] = c;
                        String next = String.valueOf(geneChar);

                        if (set.contains(next)) {
                            queue.offer(next);
                            set.remove(next);
                        }
                    }

                    geneChar[j] = old;

                }

            }
            mutation++;
        }

        return -1;

    }
}