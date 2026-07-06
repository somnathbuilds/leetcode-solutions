class Solution {
    public int pivotIndex(int[] nums) {
       int leftPrefixSum = 0;
       int rightSuffixSum = 0;
       int totalSum = 0;

       for(int i = 0; i<nums.length; i++){
        totalSum += nums[i];
       }
       for(int i = 0; i<nums.length; i++){
        rightSuffixSum = totalSum -nums[i] -leftPrefixSum;

        if(leftPrefixSum == rightSuffixSum){
            return i;
        }
        leftPrefixSum += nums[i];
      }
      return -1; 
    }
}