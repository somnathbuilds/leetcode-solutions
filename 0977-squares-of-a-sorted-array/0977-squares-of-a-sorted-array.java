class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int i = 0;
        int j = nums.length-1;
        int k = arr.length-1;
        while(i<=j){
            int isqr = nums[i]*nums[i];
            int jsqr = nums[j]*nums[j];
            if(jsqr > isqr){
                arr[k] = jsqr; 
                j--;
            }
            else{
                arr[k] = isqr;
                i++; 
            }
            k--;
        }
        return arr;
    }
}