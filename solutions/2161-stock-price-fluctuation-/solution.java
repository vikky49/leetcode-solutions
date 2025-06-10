class StockPrice {
    
    Map<Integer,Integer> time2Price;
    TreeMap<Integer,Integer> price2Count;
    int latestTimeStamp ;

    public StockPrice() {
        time2Price = new HashMap<>();
        price2Count = new TreeMap<>();
        latestTimeStamp = 0;
        
    }
    
    public void update(int timestamp, int price) {
        
        latestTimeStamp = Math.max(latestTimeStamp, timestamp);

        if(time2Price.containsKey(timestamp)) {
            //Remove the old price 
            int oldPrice = time2Price.get(timestamp);
            //Subtract the old frequency 
            price2Count.put(oldPrice, price2Count.get(oldPrice) -1 );

            if(price2Count.get(oldPrice) == 0) {
                price2Count.remove(oldPrice);
            }
        }

        time2Price.put(timestamp, price);
        price2Count.put(price, price2Count.getOrDefault(price, 0) + 1);
    }
    
    public int current() {
        return time2Price.get(latestTimeStamp);
    }
    
    public int maximum() {
        return price2Count.lastKey();
    }
    
    public int minimum() {
        return price2Count.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
