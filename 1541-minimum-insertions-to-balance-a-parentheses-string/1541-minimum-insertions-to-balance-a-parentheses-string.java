class Solution {
    public int minInsertions(String s) {
        int closeCount=0,openCount=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                if(closeCount%2==1){
                    openCount++;
                    closeCount--;
                }closeCount+=2;
            }else{
                closeCount--;
                if(closeCount<0){
                    openCount++;
                    closeCount=1;
                }
            }
        }
        return openCount+closeCount;
    }
}