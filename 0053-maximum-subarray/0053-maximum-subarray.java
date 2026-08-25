class Solution {
    public int maxSubArray(int[] nums) {
        int bestsum = nums[0];
        int result = nums[0];

        for(int i = 1; i<nums.length; i++){
            bestsum = Math.max(nums[i], bestsum + nums[i]);
            result = Math.max(result, bestsum);
        }
        return result;
    }
}