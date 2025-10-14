class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            int weight = people[left] + people[right];
            if (weight <= limit) {
                //The lightest one gets on to the boat
                left++;
            }
            //Remove the right one
            right--;
            boats++;

        }

        return boats;

    }
}