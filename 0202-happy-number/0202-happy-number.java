class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(n!=1){
            if(set.contains(n)) return false;
            set.add(n);

        int num = n;
        int sum =0;
        while(num>0){
            sum += Math.pow(num%10 , 2);
            num = num/10;
        }
        n =  sum;

        }
        return true;
    }
}