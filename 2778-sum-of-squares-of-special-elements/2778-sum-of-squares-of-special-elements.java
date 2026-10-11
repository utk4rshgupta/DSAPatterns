class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int ans =0;
        for(int i = 0;i<nums.length-1;i++){
            if(n%(i+1) ==0){
                ans +=nums[i]*nums[i];
            }
        }
        ans+=nums[n-1]*nums[n-1];
        return ans;
    }
}