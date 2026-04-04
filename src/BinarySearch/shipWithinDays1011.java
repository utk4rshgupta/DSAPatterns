package BinarySearch;

public class shipWithinDays1011 {
    class Solution {

        //410. Split Array Largest Sum Same Question

        // This problem uses binary search to find the minimum capacity required to ship all packages within D days.
        // We binary search on the possible capacities: from the maximum weight (minimum possible capacity) to the sum of all weights (maximum possible capacity).
        // For each mid capacity, we check if it's feasible to ship within D days using a greedy approach.
        public int shipWithinDays(int[] weights, int days) {
            int left = 0;
            int right =0;
            for(int x : weights){
                left = Math.max(left,x);
                right +=x;
            }
            // Binary search loop: left is the minimum possible capacity (max weight), right is the sum of all weights.
            while(left<right){
                int mid = left + (right-left)/2;
                // If feasible with mid capacity, try smaller capacities (right = mid)
                if(feasible(weights,days,mid)) right = mid;
                // Else, need larger capacity (left = mid+1)
                else left = mid+1;
            }
            // At the end, left is the minimum capacity that works
            return left;
        }
        // Feasible function: checks if we can ship all packages within D days with the given capacity.
        // Uses a greedy approach: load packages into ships until capacity is exceeded, then start a new ship.
        private boolean feasible(int[] arr , int D , int capacity){
            int total =0;
            int days = 1;
            for(int x:arr){
                total+=x;
                if(total>capacity){
                    total = x;
                    days++;
                }
            }
            // If days used <= D, it's feasible
            if(days>D) return false;
            return true;
        }
    }
}
