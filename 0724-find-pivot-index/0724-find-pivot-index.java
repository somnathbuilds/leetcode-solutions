class Solution {
    public int pivotIndex(int[] nums) {
        int prefix = 0;
        int sufix = 0;
        int total = 0;

        for(int i : nums){
            total += i;
        }
        for(int i = 0; i< nums.length; i++){
            sufix = total - nums[i] - prefix;

            if(prefix == sufix){
                return i;
            }
            prefix += nums[i];
        }
        return -1;
    }
}