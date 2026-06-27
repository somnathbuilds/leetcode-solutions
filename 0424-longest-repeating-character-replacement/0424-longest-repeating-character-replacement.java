class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int maxlength = 0;
        int maxfreq = 0;
        for(int j = 0; j<s.length(); j++){
            char right = s.charAt(j);
            map.put(right, map.getOrDefault(right, 0)+1);
            maxfreq = Math.max(maxfreq, map.get(right));
            while((j-i+1) - maxfreq > k){
                char left = s.charAt(i);
                map.put(left, map.get(left)-1);
                i++;
            }
            maxlength = Math.max(maxlength, j-i+1);
        }
        return maxlength;
    }
}