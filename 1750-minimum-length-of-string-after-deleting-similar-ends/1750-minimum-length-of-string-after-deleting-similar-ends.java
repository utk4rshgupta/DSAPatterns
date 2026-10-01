class Solution {
    public int minimumLength(String s) {
        if(s.length() == 1) return 1;
        int i =0;
        int j = s.length()-1;
        StringBuilder sb = new StringBuilder(s);

        while(i<j){
            int a = sb.charAt(i);
            int b = sb.charAt(j);
            if(a!=b) break;
            if( a == b){
                while(i<=j && sb.charAt(i) == a) i++;
                while(i<=j && sb.charAt(j) == a) j--;
            }
        }
        return j-i+1;
    }
}