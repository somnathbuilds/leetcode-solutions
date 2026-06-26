class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int bestsum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int currentsum = nums[i] + nums[j] + nums[k];
                
                if(currentsum == target){
                    return currentsum;
                }

                if (Math.abs(bestsum - target) > Math.abs(currentsum - target)) {
                    bestsum = currentsum;
                }
                    if (currentsum < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        return bestsum;
    }
}