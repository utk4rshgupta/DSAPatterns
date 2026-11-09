class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int a : nums){
            sum+=a;
        }
        if(sum%2!=0) return false;
        int target = sum/2;
        int[][] dp = new int[nums.length][target+1];
        for(int[] arr : dp) Arrays.fill(arr , -1);
        return solve(nums.length-1 , nums , target ,dp);
    }

    boolean solve(int n , int[] nums , int target, int[][] dp){
        if(target == 0) return true;
        if(n==0) return nums[0] == target;
        if(dp[n][target] != -1) return dp[n][target] == 1;
        boolean notTake = solve(n-1 , nums , target,dp);
        boolean take = false;
        if(nums[n] <= target) 
        take = solve(n-1 , nums , target-nums[n],dp);

        dp[n][target] = (notTake || take)?1:0;
        return notTake || take;
    }
}