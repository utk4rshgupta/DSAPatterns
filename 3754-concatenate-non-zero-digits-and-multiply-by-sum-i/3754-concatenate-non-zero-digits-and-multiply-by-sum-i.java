class Solution {
    public long sumAndMultiply(int n) {
        if(n==0) return 0;
        long sum = 0;
        StringBuilder s =  new StringBuilder("");
        while(n>0){
            int digit = n%10;
            sum+=digit;
            if(digit != 0){
                s.insert(0, digit);
            }
            n/=10;
        }
        long ans = sum*Integer.parseInt(s.toString());
        return ans;
    }
}