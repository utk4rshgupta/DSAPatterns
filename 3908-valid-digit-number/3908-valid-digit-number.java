class Solution {
    public boolean validDigit(int n, int x) {
      int m = n;
      if(n==0 && x ==0) return false;
      int temp1 = 0;
      int temp2 = 0;
      while(m>0){
        int dig = m%10;
        if(dig == x) temp1 = 1;
        m/=10;
      } 
      int first = n;
        while (first >= 10) {
            first /= 10;
      }

      if(first != x) temp2 = 1;
      
      return temp1 == temp2;
    }
}