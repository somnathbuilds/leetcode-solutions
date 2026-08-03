class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);

        while(low <= high){
            int mid = low + (high - low)/2;

            if(canEat(piles, h, mid)){
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return low;
    }

    //find maximum piles of bananas
    public int findMax(int[] piles){
        int max = piles[0];
        for(int bananas : piles){
            if(bananas > max){
                max = bananas;
            }
        }
        return max;
    }

    //check koko canEat or not 
    public boolean canEat(int[] piles, int h, int speed){
        long hour = 0;
        for(int bananas : piles){
           hour += Math.ceil((double)bananas/ speed);
        }
        return hour <= h;
    }
}