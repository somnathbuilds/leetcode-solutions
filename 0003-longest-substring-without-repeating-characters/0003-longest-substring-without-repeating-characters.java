class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int maxlength = 0;
        for (int j = 0; j<s.length(); j++){
            char right = s.charAt(j);
            map.put(right, map.getOrDefault(right, 0)+1);
            while(map.get(right) > 1){
                char left = s.charAt(i);
                map.put(left, map.get(left)-1);
                i++;
            }
            maxlength = Math.max(maxlength, j-i+1);
        }
        return maxlength;
    }
}