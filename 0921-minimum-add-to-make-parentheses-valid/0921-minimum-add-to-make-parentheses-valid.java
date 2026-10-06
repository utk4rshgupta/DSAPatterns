class Solution {
    public int minAddToMakeValid(String s) {
        if(s.length()==0) return 0;
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch ==')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }else {
                stack.push(ch);
            }
        }
        return stack.size();
    }
}