class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        Set<Integer> num = new HashSet<>();
        for(int first =0;first<n;first++){
            if(digits[first]==0) continue;
            for(int second =0;second<n;second++){
                if(second == first) continue;
                for(int third = 0;third<n;third++){
                    if(third == first || third == second) continue;
                    if(digits[third]%2 != 0) continue;
                    int number = digits[first]*100 + digits[second] *10 + digits[third];
                    num.add(number);
                }
            }
        }
        int[] ans = new int[num.size()];
        int i = 0;
        for(Integer it : num){
            ans[i++] = it;
        }
        Arrays.sort(ans);
        return ans;
    }
}