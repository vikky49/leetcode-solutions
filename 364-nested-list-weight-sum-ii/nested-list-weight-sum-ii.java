/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = findMaxDepth(nestedList);
        return weightedSum(nestedList, 1, maxDepth);
    }

    private int findMaxDepth(List<NestedInteger> list) {
        int depth = 1;
        for (NestedInteger nestedInteger : list) {
            if (!nestedInteger.isInteger() && nestedInteger.getList().size() > 0) {
                depth = Math.max(depth, 1 + findMaxDepth(nestedInteger.getList()));
            }
        }
        return depth;

    }

    private int weightedSum(List<NestedInteger> list, int depth, int maxDepth) {
        int sum = 0;
        for (NestedInteger nested : list) {
            if (nested.isInteger()) {
                sum += nested.getInteger() * (maxDepth - depth + 1);

            } else {
                sum += weightedSum(nested.getList(), depth + 1, maxDepth);
            }
        }

        return sum;
    }

}