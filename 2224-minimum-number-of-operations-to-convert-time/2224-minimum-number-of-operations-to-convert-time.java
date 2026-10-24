class Solution {
    public int convertTime(String current, String correct) {
        int currMin = 0;
        int corrMin = 0;
        currMin = Integer.parseInt(current.substring(0,2)) * 60;
        currMin += Integer.parseInt(current.substring(3));

        corrMin  = Integer.parseInt(correct.substring(0,2)) * 60;
        corrMin += Integer.parseInt(correct.substring(3));

        int timeDiff = Math.abs(corrMin-currMin);

        int oper =0;
        oper += timeDiff / 60;
        timeDiff %= 60;

        oper += timeDiff / 15;
        timeDiff %= 15;

        oper += timeDiff / 5;
        timeDiff %= 5;

        oper += timeDiff; 
        return oper;


    }
}