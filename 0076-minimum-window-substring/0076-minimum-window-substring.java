class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        //invalid handle
        if(t.length() > s.length()){
            return "";
        }
        //store data in map 
        for(int i = 0; i<t.length(); i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int minWindow = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int requiredcount = t.length();
        int start_i = 0;
        //check the minimum valid window  
        while(j< s.length()){
            char right = s.charAt(j);
            if(map.getOrDefault(right, 0) > 0){
                requiredcount--;
            }
            map.put(right, map.getOrDefault(right,0)-1);
            while(requiredcount == 0){
                int windowSize = j-i+1;
                if(minWindow > windowSize){
                    minWindow = windowSize;
                    start_i = i;
                }
                //window shrink
                char left = s.charAt(i);
                map.put(left, map.getOrDefault(left,0)+1);
                if(map.get(left) > 0){
                    requiredcount++;
                }
                i++;
            }
            j++;
        }
        return minWindow == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minWindow);       
    }
}