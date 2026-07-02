class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                ans *= num;
            }
        }
        if (zeroCount > 1) {
            Arrays.fill(nums, 0);
            return nums;
        }
        for(int i =0;i<nums.length;i++){
            if(nums[i] == 0){
                Arrays.fill(nums,0);
                nums[i] = ans;
                return nums;
            }
            nums[i] = ans/nums[i];
        }
        return nums;
    }
}