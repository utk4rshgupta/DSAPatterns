class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] exactCopy = score.clone();
        
        String[] ans = new String[score.length];

        Arrays.sort(exactCopy);
        for (int i = 0, k = exactCopy.length - 1; i < k; i++, k--) {
            int temp = exactCopy[i];
            exactCopy[i] = exactCopy[k];
            exactCopy[k] = temp;
        }
       

        for(int i = 0;i<score.length;i++){
            for(int j = 0;j<score.length;j++){
                if(i==0 && exactCopy[i] == score[j]){
                    ans[j] = "Gold Medal";
                    break;
                }else if(i==1 && exactCopy[i] == score[j]){
                    ans[j] = "Silver Medal";
                    break;
                }else if(i==2 && exactCopy[i] == score[j]){
                    ans[j] = "Bronze Medal";
                    break;
                }else if(exactCopy[i] == score[j]){
                    ans[j] = String.valueOf(i+1);
                }
            }
        }
        return ans;
    }
}