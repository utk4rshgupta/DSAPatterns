class Solution {
    public String removeOuterParentheses(String s) {
       int depth =0;
       StringBuilder  str = new StringBuilder("");
       for(int i =0;i<s.length();i++){
        if(s.charAt(i) == '('){
            if(depth>0) str.append('(');
            depth++;
        }else{
            depth--;
            if(depth>0) str.append(')');
        }
       } 
       return str.toString();
    }
}