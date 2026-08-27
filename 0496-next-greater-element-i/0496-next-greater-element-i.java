class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums2.length; i++){
            while(!st.isEmpty() && nums2[i] > st.peek()){
                map.put(st.pop(), nums2[i]);
            }
            st.push(nums2[i]);
        }
        while(!st.isEmpty()){
            map.put(st.pop(), -1);
        }
        int[] arr = new int[nums1.length];
        for(int j = 0; j<nums1.length; j++){
            arr[j] = map.get(nums1[j]);
        }
        return arr;
    }
}