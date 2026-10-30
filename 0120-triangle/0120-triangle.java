class Solution {
    int n;
    public int minimumTotal(List<List<Integer>> triangle) {
        // recursion 
        
        //     public int minimumTotal(List<List<Integer>> triangle) {
            
        //     return minTotal(0,0,triangle);
        // }

        // int minTotal(int i , int j , List<List<Integer>> triangle){
        //     int n = triangle.size();
        //     if(i == n-1) return triangle.get(i).get(j);
        //     int down = triangle.get(i).get(j) + minTotal(i+1,j,triangle);
        //     int diagonal = triangle.get(i).get(j) + minTotal(i+1,j+1 , triangle);
        //     return Math.min(down , diagonal);

        // }

        // Memoization

        //     n = triangle.size();
        //     int[][] dp = new int[n][n];
        //     for(int[] arr : dp){
        //         Arrays.fill(arr , -1);
        //     }
        //     return minTotal(0,0,triangle , dp);
        // }

        // int minTotal(int i , int j , List<List<Integer>> triangle , int[][] dp){
        //     if(i == n-1) return triangle.get(i).get(j);
        //     if(dp[i][j] != -1) return dp[i][j];
        //     int down = triangle.get(i).get(j) + minTotal(i+1,j,triangle, dp);
        //     int diagonal = triangle.get(i).get(j) + minTotal(i+1,j+1 , triangle, dp);
        //     return dp[i][j] = Math.min(down , diagonal);

            //Tabulation
            
            int n = triangle.size();
            int[][] dp = new int[n][n];
            for(int j =0;j<n;j++){
                dp[n-1][j] = triangle.get(n-1).get(j);
            }

            for(int i = n-2;i>=0;i--){
                for(int j =i ;j>=0;j--){
                    int down = triangle.get(i).get(j) + dp[i+1][j];
                    int dia = triangle.get(i).get(j) + dp[i+1][j+1];
                    dp[i][j] = Math.min(down, dia);

                }
            }
            return dp[0][0];
    }
}