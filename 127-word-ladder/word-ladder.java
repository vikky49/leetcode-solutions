class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();

        //Early optimization
        if (!dict.contains(endWord)) {
            return 0;
        }

        queue.offer(beginWord);
        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(endWord)) {
                    return steps;
                }

                char[] words = current.toCharArray();

                for (int j = 0; j < words.length; j++) {
                    char old = words[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        words[j] = c;

                        String newWord = String.valueOf(words);

                        if (dict.contains(newWord)) {
                            queue.offer(newWord);
                            //Remove the word
                            dict.remove(newWord);
                        }
                    }

                    words[j] = old;
                }

            }
            steps++;
        }

        return 0;

    }
}