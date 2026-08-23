class Solution {
    public boolean sumGame(String num) {
       int Lsum =0 , Rsum = 0;
       int Lq = 0 , Rq=0;
       for(int i =0;i<num.length()/2;i++){
        if(num.charAt(i) == '?') Lq++;
        else Lsum += num.charAt(i) - '0';
       }
       for(int i =num.length()/2;i<num.length();i++){
        if(num.charAt(i) == '?') Rq++;
        else Rsum += num.charAt(i) - '0';
       }
       return (Lsum-Rsum)*2 != (Rq -Lq)*9;
        
    }
}