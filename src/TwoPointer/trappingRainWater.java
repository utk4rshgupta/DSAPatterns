package TwoPointer;

public class trappingRainWater {

    //https://leetcode.com/problems/trapping-rain-water/description/
    public int trap(int[] height) {
        int left =0;
        int right = height.length-1;
        int ans = 0;
        int leftMax=Integer.MIN_VALUE;
        int rightMax=Integer.MIN_VALUE;
        while(left<right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if(leftMax<rightMax){
                ans+=leftMax-height[left];
                left++;
            }else{
                ans+=rightMax-height[right];
                right--;
            }
        }
        return ans;
    }
}
