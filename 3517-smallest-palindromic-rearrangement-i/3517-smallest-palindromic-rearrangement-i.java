class Solution {
    public String smallestPalindrome(String s) {
        if(s.length()==1) return s;
        int temp =0;
        String mid = "";
        if(s.length()%2==1) {
            mid = String.valueOf(s.charAt((s.length()/2)));
            temp =1;
        }
        String half = s.substring(0,s.length()/2);
        char[] ans = half.toCharArray();
        Arrays.sort(ans);
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<ans.length;i++){
            sb.append(ans[i]);
        }
        if(temp == 1) sb.append(mid);
        for(int i =ans.length-1;i>=0;i--){
            sb.append(ans[i]);
        }
        return sb.toString() ;

    }
}