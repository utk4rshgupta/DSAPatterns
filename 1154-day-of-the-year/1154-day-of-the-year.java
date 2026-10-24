class Solution {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0,4));
        boolean leap = (year%100 != 0 && year %4 ==0) || year%400==0;

        int days[]  = {31 , leap?29:28 , 31,30,31,30,31,31,30,31,30,31};

        int totalDays[] = new int[13];
        int dayNum =0;

        totalDays[0]=0;
        for(int i =1;i<=days.length;i++){
            totalDays[i] = totalDays[i-1]+days[i-1];
        }

        int month = Integer.parseInt(date.substring(5,7));
        dayNum = totalDays[month-1];
        dayNum+=Integer.parseInt(date.substring(8));

        return dayNum;

        
    }
}