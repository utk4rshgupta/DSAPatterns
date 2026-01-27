package TwoPointer;

public class TwoSum {
    //https://leetcode.com/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {
        int brr[] = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++)
                if(nums[i]+nums[j]==target){
                    brr[0]=i;
                    brr[1]=j;
                    return brr;
                }
        }
        return brr;
    }
}
