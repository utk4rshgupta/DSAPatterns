package BinarySearch;

public class minDaysForMBouquet {
    //https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

    /*
     * PROBLEM STATEMENT:
     * Given an array bloomDay where bloomDay[i] is the day the flower blooms,
     * find the minimum number of days needed to make exactly m bouquets.
     * Each bouquet requires k consecutive bloomed flowers.
     * 
     * EXAMPLE:
     * bloomDay = [1,10,3,10,2], m = 3, k = 1
     * Answer: 3
     * On day 1: flower at index 0 blooms -> can make 1 bouquet
     * On day 3: flowers at index 0,2 bloom -> can make 2 bouquets
     * On day 10: flowers at indices 0,1,2,3,4 bloom -> can make 3 bouquets (need only 1 more)
     * So minimum days = 3
     * 
     * APPROACH: Binary Search + Greedy
     * 1. If m*k > bloomDay.length, it's impossible to make m bouquets, return -1
     * 2. Binary search on the answer: search between day 0 and max bloom day
     * 3. For each mid day, check if we can make at least m bouquets by that day (feasible function)
     * 4. If feasible, try to find earlier day (search left), else search right
     * 5. Greedy approach in feasible: whenever we get k consecutive bloomed flowers, make a bouquet
     * 
     * TIME COMPLEXITY: O(n * log(max_day)) where n is length of bloomDay
     * SPACE COMPLEXITY: O(1)
     */

    public int minDays(int[] bloomDay, int m, int k) {
        // Edge case: if total flowers needed > available flowers, impossible
        if((long)m*k > bloomDay.length) return -1;
        
        // Initialize binary search boundaries
        int left = 0;  // Minimum possible answer
        int right = 0; // Maximum possible answer (latest bloom day)
        for(int x : bloomDay){
            right = Math.max(right, x);  // Find the maximum bloom day
            left = Math.min(left, x);    // Find the minimum bloom day
        }
        
        // Binary search for the minimum days needed
        while(left < right){
            int mid = left + (right - left) / 2;  // Avoid overflow
            
            // Check if we can make m bouquets by day 'mid'
            if(feasible(bloomDay, m, k, mid)) {
                // If possible, try to find an earlier day
                right = mid;
            } else {
                // If not possible, we need more days
                left = mid + 1;
            }
        }
        return left;  // 'left' is the minimum days needed
    }
    
    /*
     * FEASIBLE HELPER FUNCTION:
     * Checks if we can make at least m bouquets by day 'day' using greedy approach
     * 
     * GREEDY STRATEGY:
     * - Iterate through flowers in order
     * - Count consecutive bloomed flowers (bloom <= day)
     * - When we have k consecutive bloomed flowers, make a bouquet immediately
     * - If we encounter a non-bloomed flower, reset the counter (lose the chain)
     * 
     * KEY INSIGHT: It's always optimal to make a bouquet as soon as we have k consecutive
     * bloomed flowers because delaying won't give us a better result
     * 
     * EXAMPLE with bloomDay = [1,10,3,10,2], m = 3, k = 1, day = 3:
     * - Index 0: bloom=1 <= 3, flower=1, flower==k(1), make bouquet, bouquet=1, flower=0
     * - Index 1: bloom=10 > 3, flower=0 (chain broken)
     * - Index 2: bloom=3 <= 3, flower=1, flower==k(1), make bouquet, bouquet=2, flower=0
     * - Index 3: bloom=10 > 3, flower=0 (chain broken)
     * - Index 4: bloom=2 <= 3, flower=1, flower!=k(1), continue
     * Result: bouquet=2 >= m(3)? No, so day 3 is not feasible
     */
    private boolean feasible(int[] bloomDay, int m, int k, int day){
        int bouquet = 0;  // Count of bouquets made so far
        int flower = 0;   // Count of consecutive bloomed flowers
        
        for(int bloom: bloomDay){
            if(bloom <= day){
                // Flower has bloomed by this day
                flower++;
                if(flower == k){
                    // We have k consecutive bloomed flowers, make a bouquet
                    bouquet++;
                    flower = 0;  // Reset counter for next bouquet
                }
            } else {
                // Flower hasn't bloomed yet, chain is broken
                flower = 0;
            }
        }
        
        // Return true if we can make at least m bouquets by this day
        return bouquet >= m;
    }
}
