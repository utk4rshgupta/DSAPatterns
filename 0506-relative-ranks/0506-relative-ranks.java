class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] ans = new String[score.length];
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : score){
            heap.offer(i);
        }
        int i =-1;
        while(!heap.isEmpty()){
            int a = heap.poll();
            i++;
            for(int j = 0;j<score.length;j++){
               if(i==0 && a == score[j]){
                    ans[j] = "Gold Medal";
                    break;
                }else if(i==1 && a == score[j]){
                    ans[j] = "Silver Medal";
                    break;
                }else if(i==2 && a == score[j]){
                    ans[j] = "Bronze Medal";
                    break;
                }else if(a == score[j]){
                    ans[j] = String.valueOf(i+1);
                }
            }
        }
        return ans;
    }
}