class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] daysTillMonth = new int[monthDays.length+1];
        daysTillMonth[0] = 0;
        for (int i = 1; i <= monthDays.length; i++) {
            daysTillMonth[i] = daysTillMonth[i - 1] + monthDays[i - 1];
        }

        int arrA = noOfDays(arriveAlice , daysTillMonth);
        int depA = noOfDays(leaveAlice , daysTillMonth);;
        int arrB = noOfDays(arriveBob , daysTillMonth);;
        int depB = noOfDays(leaveBob , daysTillMonth);;
    
        // char[] a = arriveAlice.toCharArray();
        //     if(a[0] -'0' == 1){
        //         month = 10*(a[0] -'0')+a[1]-'0';
        //         arrA = daysTillMonth[month-1];
        //     }else{
        //         month = a[1]-'0';
        //         arrA = daysTillMonth[month-1];
        //     }
        //     int days = 10*(a[3] -'0')+a[4]-'0';
        //     arrA += days;


        // char[] b = leaveAlice.toCharArray();
        //     if(b[0] -'0' == 1){
        //         month = 10*(b[0] -'0')+b[1]-'0';
        //         depA = daysTillMonth[month-1];
        //     }else{
        //         month = b[1]-'0';
        //         depA = daysTillMonth[month-1];
        //     }
        //     days = 10*(b[3] -'0')+b[4]-'0';
        //     depA += days;

        // char[] c = arriveBob.toCharArray();
        //     if(c[0] -'0' == 1){
        //         month = 10*(c[0] -'0')+c[1]-'0';
        //         arrB = daysTillMonth[month-1];
        //     }else{
        //         month = c[1]-'0';
        //         arrB = daysTillMonth[month-1];
        //     }
        //     days = 10*(c[3] -'0')+c[4]-'0';
        //     arrB += days;
            
        
        // char[] d = leaveBob.toCharArray();
        //     if(d[0] -'0' == 1){
        //         month = 10*(d[0] -'0')+d[1]-'0';
        //         depB = daysTillMonth[month-1];
        //     }else{
        //         month = d[1]-'0';
        //         depB = daysTillMonth[month-1];
        //     }
        //     days = 10*(d[3] -'0')+d[4]-'0';
        //     depB += days;
            

        int arr = Math.max(arrA,arrB);
        int dep = Math.min(depA , depB);
        if(dep>=arr)
        return dep-arr+1 ;

        return 0;



    }
    int noOfDays(String str , int[] daysTillMonth){
        int days =0;
        int month =0;
        char[] a = str.toCharArray();
            if(a[0] -'0' == 1){
                month = 10*(a[0] -'0')+a[1]-'0';
                days = daysTillMonth[month-1];
            }else{
                month = a[1]-'0';
                days = daysTillMonth[month-1];
            }
            days += 10*(a[3] -'0')+a[4]-'0';
            
            return days;
    }
}