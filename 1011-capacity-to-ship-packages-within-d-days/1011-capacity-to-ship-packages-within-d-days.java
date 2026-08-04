class Solution {
    public int shipWithinDays(int[] weights, int days) {

        if(days > weights.length){
            return -1;
        }
        long low = 0;
        long high = 0;
        for(int i = 0; i < weights.length; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }
        while(low <= high){
            long mid = low + (high -low)/2;

            if(shipCapacity(weights, days, mid)){
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return (int)low;
    }
    //Helping function to check conveyor transmit given days 
    public boolean shipCapacity(int[] weights, int days, long mid){
        int k = 1;
        long packages = 0;
        for(int i = 0; i < weights.length; i++){
            if(packages + weights[i] <= mid){
                packages += weights[i];
                continue;
            } else {
                k++;
                packages = weights[i];
                if(k > days){
                    return false;
                }
            }
        }
        return true;
    }
}