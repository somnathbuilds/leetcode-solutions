class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int j = nums.length-1;
        int k = arr.length-1;
        int i = 0;
        while(i <= j){
            int isqr = nums[i]*nums[i];
            int jsqr = nums[j]*nums[j];
            
            if(isqr < jsqr){
                arr[k] = jsqr;
                k--;
                j--;
            }
            else{
                arr[k] = isqr;
                k--;
                i++;
            }
        }
        return arr;
    }
}