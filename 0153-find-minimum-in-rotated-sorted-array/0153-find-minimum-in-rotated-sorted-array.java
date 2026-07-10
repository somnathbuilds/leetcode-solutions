class Solution {
    public int findMin(int[] nums) {
        int i = 0;
        while(i< nums.length-1){
            if(nums[i] < nums[i+1]){
                i++;
            } else{
                return nums[i+1];
            }
        }
        return nums[0];
    }    
}