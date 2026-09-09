class Solution {
    public long countCommas(long n) {
        long start =1000;
        long comma = 0;
        if(n<=999) return 0;

        while(start<=n){
            comma +=n-start+1;
            start*=1000;
        }
        return comma;
    }
}