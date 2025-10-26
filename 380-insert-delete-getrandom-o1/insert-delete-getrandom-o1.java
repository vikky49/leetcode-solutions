class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;

    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);
        return true;

    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        //Swap the current with the last element
        //current index for the val
        int index = map.get(val);

        //last element in the list
        int lastElement = list.get(list.size() - 1);

        //update the current index with the last Element
        list.set(index, lastElement);
        //update the index
        map.put(lastElement, index);

        //Remove the last Element
        map.remove(val);
        list.remove(list.size() - 1);

        return true;

    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */