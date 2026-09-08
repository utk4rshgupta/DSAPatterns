class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] line = new int[102];
        for(int i =0;i<nums.size();i++){
            line[nums.get(i).get(0)]++;
            line[nums.get(i).get(1) + 1]--;
        }
        int total =0;
        int ans =0;
        for(int i = 0;i<102;i++){
            total+=line[i];
            if(total>0) ans++;
        }
        return ans;
    }
}