class Solution {

    class pair {
        int count;
        char ch;

        pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }  

        public String removeDuplicates(String s, int k) {
            Stack<pair> stack = new Stack<>();
            for(char ch : s.toCharArray()) {
                if(stack.isEmpty() || stack.peek().ch != ch){
                    stack.push(new pair(ch ,1));
                } else{
                    stack.peek().count++;
                    if(stack.peek().count == k){
                        stack.pop();
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(pair p : stack){
                for(int i = 0; i<p.count; i++){
                    sb.append(p.ch);
                }
            }
        return sb.toString();
    }
}