class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int result = Math.abs(nums[0]);

        for(int i = 1; i<nums.length; i++){
            min = Math.min(nums[i], min + nums[i]);
            max = Math.max(nums[i], max + nums[i]);
            result = Math.max(result, Math.max(Math.abs(max), Math.abs(min)));
        }
        return result;
    }
}