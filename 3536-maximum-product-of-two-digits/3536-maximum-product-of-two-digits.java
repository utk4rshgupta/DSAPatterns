class Solution {
    public int maxProduct(int n) {
        int num1 = n;
        int ans = 0;
        while(num1>0){
            int dig = num1%10;
            int num2 = (num1/10);
            while(num2>0){
                int dig2 = num2%10;
                ans = Math.max(ans , dig*dig2);
                num2/=10;
            }
            num1/=10;
        }
        return ans ;
    }
}