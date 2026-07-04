class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int result = nums[0];

        for(int i = 1; i<nums.length; i++){
            int opt1 = nums[i];
            int opt2 = max * nums[i];
            int opt3 = min * nums[i];
            min = Math.min(opt1, Math.min(opt2, opt3));
            max = Math.max(opt1, Math.max(opt2, opt3));
            result = Math.max(result, Math.max(min, max));
        }
        return result;
    }
}