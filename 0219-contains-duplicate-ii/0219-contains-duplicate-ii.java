class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // Kya ye number pehle aa chuka hai?
            if (map.containsKey(nums[i])) {

                int previousIndex = map.get(nums[i]);

                // Distance check
                if (i - previousIndex <= k) {
                    return true;
                }
            }

            // Current index ko last index bana do
            map.put(nums[i], i);
        }

        return false;
    }
}