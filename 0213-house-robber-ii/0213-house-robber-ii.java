class Solution {
    public int rob(int[] nums) {
        if(nums.length ==1 ) return nums[0];
        int[]  temp1 = new int[nums.length];
        int[] temp2 = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            if(i!=0) temp1[i] = nums[i];
            if(i!=nums.length-1) temp2[i] = nums[i];
        }
        return Math.max(loot(temp1) , loot(temp2));
    }
    int loot(int nums[]){
        int prev1 =0;
        int prev2 =0;
        for(int i =0;i<nums.length;i++){
            int take = prev2 + nums[i];
            int skip = prev1;
            int curr = Math.max(take , skip);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}