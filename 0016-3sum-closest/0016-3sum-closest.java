class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int bestSum = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < nums.length -2; i++){
            int j = i +1;
            int k = nums.length -1;

            while(j<k){
                int Sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(bestSum - target) > Math.abs(Sum - target)){
                    bestSum = Sum;
                }
                if(Sum < target){
                    j++;
                } else if(Sum > target){
                    k--;
                } else {
                    return bestSum;
                }
            }
        }
        return bestSum;
    }
}