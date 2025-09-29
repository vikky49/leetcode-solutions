class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];

        queue.offer(0);

        while (!queue.isEmpty()) {
            int start = queue.poll();

            if (visited[start]) {
                continue;
            }

            visited[start] = true;

            //Try all possible and positions
            for (int end = start + 1; end <= s.length(); end++) {
                String word = s.substring(start, end);

                if (wordSet.contains(word)) {
                    if (end == s.length()) {
                        //reached the end
                        return true;
                    }

                    queue.offer(end);
                }
            }
        }

        return false;

    }
}
