class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] line = new int[52];
        for(int[] l : ranges){
            line[l[0]]++;
            line[l[1] +1]--;
        }
        int cover =0;
        for(int i = 0 ;i<line.length;i++){
            cover+=line[i];
            if(i >=left && i<=right && cover == 0) return false;
            if(i==right) return true;
        }
        return true;

        
    }
}