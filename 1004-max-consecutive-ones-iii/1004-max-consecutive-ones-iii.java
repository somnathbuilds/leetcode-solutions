class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int zero = 0;
        int maxlength = 0;
        for (int j = 0; j< nums.length; j++){
            if(nums[j] == 0){
                zero++;
            }
            while(zero > k){
                if(nums[i] == 0){
                    zero--;
                }
                i++;
            }
            maxlength = Math.max(maxlength, j-i+1);
        }
        return maxlength;
    }
}