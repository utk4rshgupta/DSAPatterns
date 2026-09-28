class Solution {
    public int maxDepth(String s) {
        int ans =0;
        int curr =0;
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                curr++;
                ans = Math.max(curr , ans);
            }
            if(c==')') curr--;
        }
        return ans;
    }
}