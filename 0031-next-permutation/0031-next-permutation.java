class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        for(int i = nums.length-1;i>=0;i--){
            if(i>0 && nums[i] > nums[i-1]){
                index = i-1;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int index2 =0;
        for(int i = nums.length-1;i>=0;i--){
            if(nums[index] < nums[i]){
                index2 =i;
                break;
            }
        }
        int temp = nums[index];
        nums[index] = nums[index2];
        nums[index2] = temp;
        reverse(nums , index +1, nums.length-1);
        return;
    }
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

}