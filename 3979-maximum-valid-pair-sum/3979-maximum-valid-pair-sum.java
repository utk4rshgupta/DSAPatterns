class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int maxSum= Integer.MIN_VALUE;
        int maxLeft = Integer.MIN_VALUE;

        for(int j  =k;j<n;j++){
            int i = j-k;
            maxLeft = Math.max(maxLeft , nums[i]);
            maxSum = Math.max(maxSum,maxLeft+nums[j]);
        }
        return maxSum;
    }
}