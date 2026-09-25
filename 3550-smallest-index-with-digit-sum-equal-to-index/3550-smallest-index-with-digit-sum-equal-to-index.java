class Solution {
    public int smallestIndex(int[] nums) {
        for(int i =0;i<nums.length;i++){
            if(i == digSum(nums[i])) return i;
        }
        return -1;
    }
    int digSum(int num ){
        if(num<10) return num;
        int x = num;
        int ans =0;
        while(x>0){
            ans+=x%10;
            x/=10;
        }
        return ans;
    }
}