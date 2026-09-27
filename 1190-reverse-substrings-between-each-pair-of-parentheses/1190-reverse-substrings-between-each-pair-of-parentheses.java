class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<s.length();i++){
            char c = sb.charAt(i);
            if(c =='(') st.push(i);
            if(c ==')'){
                int start = st.pop();
                reverse(start+1,i-1,sb);
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i =0;i<sb.length();i++){
            if(sb.charAt(i) != '(' && sb.charAt(i) != ')')
             result.append(sb.charAt(i));
        }
        return result.toString();
    }
    void reverse(int i , int j , StringBuilder sb){
        int a = i;
        int b = j;
        while(a<b){
            char c = sb.charAt(a);
            sb.setCharAt(a , sb.charAt(b));
            sb.setCharAt(b,c);
            a++;
            b--;
        }
    }
}