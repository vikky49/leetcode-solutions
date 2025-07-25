class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> {
                int distanceA = a[0] * a[0] + a[1] * a[1];
                int distanceB = b[0] * b[0] + b[1] * b[1];

                return distanceB - distanceA;
            });

            //Process all the points

            for(int[] point : points) {

                maxHeap.add(point);

                //If heap exceeds more than K
                if(maxHeap.size() > k) {
                  maxHeap.poll();
                }
            }

            int result[][] = new int[k][2];
            for(int i = 0; i < k ; i++) {
                result[i] = maxHeap.poll();
            }

            return result;

    }
}
