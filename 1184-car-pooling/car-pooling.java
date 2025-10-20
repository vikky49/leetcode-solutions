class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        int[] changes = new int[1001];

        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            changes[from] += passengers;
            changes[to] -= passengers;

        }

        int currentPassengers = 0;
        for (int change : changes) {
            currentPassengers += change;

            if (currentPassengers > capacity) {
                return false;
            }
        }
        return true;
    }
}

//Alternative Solution with hashmap
/*    Map<Integer, Integer> changes = new HashMap<>();

    for (int[] trip : trips) {

        int passengers = trip[0];
        int from = trip[1];
        int to = trip[2];

        changes.put(from, changes.getOrDefault(from, 0) + passengers);
        changes.put(to, changes.getOrDefault(to, 0) - passengers);

    }

    List<Integer> locations = new ArrayList<>(changes.keySet());
    Collections.sort(locations);

    int currentPassengers = 0;
    for (int location : locations) {
        currentPassengers += changes.get(location);
        if (currentPassengers > capacity) {
            return false;
        }
    }

    return true;

} */
