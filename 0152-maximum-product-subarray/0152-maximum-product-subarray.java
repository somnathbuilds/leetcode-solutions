class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length; i++){
            int opt1 = nums[i];
            int opt2 = maxProduct * nums[i];
            int opt3 = minProduct * nums[i];
            maxProduct = Math.max(opt1, Math.max(opt2, opt3));
            minProduct = Math.min(opt1, Math.min(opt2, opt3));
            result = Math.max(result, Math.max(maxProduct, minProduct));
        }
        return result; 
    }
}