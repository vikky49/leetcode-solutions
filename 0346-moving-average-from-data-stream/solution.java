class MovingAverage {
    
    Queue<Integer> queue = new LinkedList<>();
    int maxSize;
    int totalSoFar = 0;

    public MovingAverage(int size) {
        this.maxSize = size;
        
    }
    
    public double next(int val) {
        
        queue.add(val);
        totalSoFar += val;
        
        if(queue.size() > maxSize) {
            int poppedElement = queue.remove();
            totalSoFar -= poppedElement;
        }
        
        return totalSoFar * 1.0 / queue.size();
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
