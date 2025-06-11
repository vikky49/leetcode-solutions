class Solution {
       public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i=0 ; i < flowerbed.length ; i++) {
            //check if the plot is empty
            if(flowerbed[i] == 0) {
                boolean leftPlotEmpty = i == 0 || flowerbed[i-1] == 0;
                boolean rightPlotEmpty = i == flowerbed.length-1 || flowerbed[i+1] == 0;
                if(leftPlotEmpty && rightPlotEmpty) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
        
    }
}
