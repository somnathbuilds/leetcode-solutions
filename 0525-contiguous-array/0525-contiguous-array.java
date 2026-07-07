class Solution {
    public int findMaxLength(int[] nums) {
        int Zero = 0;
        int One = 0;
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0){
                Zero++;
            } else{
                One++;
            }
            int diff = Zero - One;
            if(diff == 0){
                result = Math.max(result, i+1);
            } else if(map.containsKey(diff)){
                result = Math.max(result, i - map.get(diff));
            } else{
                map.put(diff, i);
            }
        }
        return result;
    }
}