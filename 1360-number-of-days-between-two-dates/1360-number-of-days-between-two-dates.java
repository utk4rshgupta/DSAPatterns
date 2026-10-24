class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysCount(date1)-daysCount(date2));

    }
    int daysCount(String date){
        int year = Integer.parseInt(date.substring(0,4));
        boolean leap = (year%4 ==0 && year%100 !=0 ) || year%400 ==0;
        int noOfDays =0;

        for(int i =1970;i<year;i++){
            boolean leapI = (i % 4 == 0 && i % 100 != 0) || i % 400 == 0;
            noOfDays += leapI ? 366 : 365;
        }
        int[] days ={ 31,leap?29:28 ,31,30,31,30,31, 31,30,31,30,31};
        int[] totalDays = new int[13];
        totalDays[0] =0;
        for(int i =1;i<=days.length;i++){
            totalDays[i] = days[i-1]+totalDays[i-1];
        }

        int month = Integer.parseInt(date.substring(5,7));
        noOfDays+=totalDays[month-1];
        noOfDays+= Integer.parseInt(date.substring(8));
        return noOfDays;


    }
}