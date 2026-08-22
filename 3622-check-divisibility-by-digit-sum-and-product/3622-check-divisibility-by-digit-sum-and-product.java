class Solution {
    public boolean checkDivisibility(int n) {
        int sum =0;
        int mul =1;
        int x = n;
        while(x>0){
            int dig = x%10;
            sum += dig;
            mul*=dig;
            x/=10;
        }
        
        return (n%(sum+mul) == 0);

    }
}