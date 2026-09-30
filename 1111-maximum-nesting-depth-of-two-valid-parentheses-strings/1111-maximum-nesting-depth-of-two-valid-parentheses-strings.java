class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int open =0;
        for(int i =0;i<seq.length();i++){
            char c = seq.charAt(i);
            if(c =='('){
                open++;
                ans[i] = open%2;
            }else{
                ans[i] = open%2;
                open--;
            }
        }
        return ans;
    }
}