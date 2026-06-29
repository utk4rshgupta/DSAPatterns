class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n , result,0,0,"");
        return result;
    }
    private void helper(int n , List<String> result,int open , int close,String str){
        if(str.length() == 2*n) {
            result.add(str);
            return;
        }
        if(open<n)
        helper(n,result,open+1,close,str+"(");
        if(close<open)
        helper(n,result,open,close+1,str+")");
    }

}