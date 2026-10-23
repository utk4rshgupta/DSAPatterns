class Solution {
    public int countHillValley(int[] nums) {
        boolean[] deDup = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]) deDup[i+1] = true;
        }
        for(int i =0;i<deDup.length;i++){
            if(deDup[i] == false) list.add(nums[i]);
        }

        int ans = 0;
        for(int i =1 ;i<list.size()-1;i++){
            if(list.get(i-1)<list.get(i) && list.get(i) > list.get(i+1)) ans++;
            if(list.get(i-1)>list.get(i) && list.get(i) < list.get(i+1)) ans++;
        }
        return ans;

    }
}