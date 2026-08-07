class Solution {
    public int leastInterval(char[] tasks, int n) {

        int [] freq = new int[26];
        //maxfreq nikalo
        int maxfreq = 0;
        for(char ch : tasks){
            freq[ch -'A']++;
            maxfreq = Math.max(maxfreq, freq[ch -'A']);
        }
        //maxcount nikalo
        int countmax = 0;
        for(int f : freq){
            if(f == maxfreq){
                countmax++;
            }
        }
        int formula = (maxfreq - 1)*(n + 1) + countmax;
        return Math.max(tasks.length, formula);
    }
}