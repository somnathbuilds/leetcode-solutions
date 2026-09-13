class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        // Mark the numbers that exist
        for (int i = 0; i < nums.length; i++) {

            int num = Math.abs(nums[i]);

            nums[num - 1] = -Math.abs(nums[num - 1]);
        }

        // Find unmarked positions
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}