class Solution {
    public boolean validDigit(int n, int x) {
      boolean found=false;
        while(n>=10){
            if(n%10==x){
                found=true;
            }
            n=n/10;
        }
        return found && n!=x;
    }
}