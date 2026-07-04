class Solution {
    public int maxSubArray(int[] nums) {
        int bestsum = nums[0];
        int result = nums[0];

        for(int i = 1; i<nums.length; i++){
            int opt1 = nums[i];
            int opt2 = bestsum + nums[i];
            bestsum = Math.max(opt1, opt2);
            result = Math.max(result, bestsum);
        }
        return result;
    }
}