class Solution {
    class pair{
        int count;
        char ch;
        pair(char ch, int count){
            this.count = count;
            this.ch = ch; 
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack <pair> st = new Stack<>(); 
        for( char ch : s.toCharArray()) {
            if(st.isEmpty() || st.peek().ch != ch){
                st.push(new pair(ch,1));
            } else{
                st.peek().count++;
                if(st.peek().count == k){
                    st.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(pair p : st){
            for(int i = 0; i<p.count; i++){
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }
}