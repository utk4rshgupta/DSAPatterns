class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // long out = 0;
        // StringBuilder str = new StringBuilder();
        // long limit =1;
        // int ans =0;
        // while(num-->0){
        //     limit *=10;
        // }
        // long score =0;
        // for(int i =0;i<limit;i++){
        //     long  digitSum =0;
        //     long sqSum =0;
        //     long n = i;
            
        //     while(n>0){
        //         long  dig = n%10;
        //         digitSum +=dig;
        //         n/=10;
        //     }
        //     n=i;
        //     if(digitSum == sum){
        //         while(n>0){
        //             long dig = n%10;
        //             sqSum += dig*dig;
        //             n/=10;
        //         }
        //         if(score<=sqSum){
        //             score = sqSum;
        //             if(out<i)
        //                out = i;
        //         }
                
        //     }
        // }
        // if(out==0) return "";
        // return String.valueOf(out);
        if (sum > 9 * num) return "";

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum);
            str.append(digit);
            sum -= digit;
        }

        if (sum != 0) return "";

        return str.toString();
    }
}