class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        //Always add the first one to 1
        result.add(new ArrayList<>());

        result.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            //Add arrayList to each index
            List<Integer> row = new ArrayList<>();

            List<Integer> prevRow = result.get(rowNum - 1);

            //Add the first element as 1
            row.add(1);

            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            //Last element is always 1
            row.add(1);

            result.add(row);
        }

        return result;

    }
}