
class FreqStack {

    private Map<Integer, Integer> frequency;
    private PriorityQueue<HeapElement> maxHeap;
    private int index;

    public FreqStack() {
        this.frequency = new HashMap<>();
        this.maxHeap = new PriorityQueue<>((a, b) -> {

            if (a.freq != b.freq) {
                return b.freq - a.freq; //return high frequency
            }

            return b.insertionIndex - a.insertionIndex; // return the insertion index

        });
        index = 0;
    }

    public void push(int val) {

        frequency.put(val, frequency.getOrDefault(val, 0) + 1);
        maxHeap.offer(new HeapElement(
                val,
                frequency.get(val),
                index++));

    }

    public int pop() {
        HeapElement element = maxHeap.poll();
        int val = element.value;
        frequency.put(val, frequency.get(val) - 1);
        return val;

    }

    private static class HeapElement {
        int value;
        int freq;
        int insertionIndex;

        HeapElement(
                int value,
                int freq,
                int index) {
            this.value = value;
            this.freq = freq;
            this.insertionIndex = index;
        }
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */