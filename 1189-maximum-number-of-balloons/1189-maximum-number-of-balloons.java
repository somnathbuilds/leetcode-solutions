class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for(int i=0; i<text.length(); i++){
            freq[text.charAt(i) - 'a']++;
        }
        int b = freq['b' - 'a'];
        int a = freq['a' - 'a'];
        int l = freq['l' - 'a']/2;
        int o = freq['o' - 'a']/2;
        int n = freq['n' - 'a'];

        int ans = Math.min(b, a);
        ans = Math.min(ans, l);
        ans = Math.min(ans, o);
        ans = Math.min(ans, n);

        return ans;
    }
}