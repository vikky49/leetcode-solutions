class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String string : strs) {
            char[] charArray = string.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);

            anagrams.computeIfAbsent(sorted, k -> new ArrayList<>())
                    .add(string);
        }

        return new ArrayList<>(anagrams.values());

    }
}