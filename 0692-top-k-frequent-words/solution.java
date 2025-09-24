class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        //Map the frequencies 
        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        //Use max heap
        PriorityQueue<String> heap = new PriorityQueue<>(
                (word1, word2) -> {
                    //if frequencies are equal - then compare the words
                    if (freq.get(word1).equals(freq.get(word2))) {
                        return word1.compareTo(word2);
                    }
                    //other wise return by the count
                    return freq.get(word2) - freq.get(word1);
                });

        //Add the keys to the heap
        for (String word : freq.keySet()) {
            heap.offer(word);
        }

        //Extract the top k elements 
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(heap.poll());
        }

        return result;

    }
}
