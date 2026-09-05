class Solution {
    class DS{
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        public DS(int n ){
            for(int i =0;i<n;i++){
                parent.add(i);
                size.add(1);
            }
        }
        public int findUPar(int node){
            if(node == parent.get(node)) return node;
            int ulp = findUPar(parent.get(node));
            parent.set(node , ulp);
            return parent.get(node);
        }

        public void unionBySize(int u , int v){
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if(ulp_u == ulp_v) return;

            if(size.get(ulp_u)<size.get(ulp_v)){
                parent.set(ulp_u , ulp_v);
                size.set(ulp_v , size.get(ulp_v)+size.get(ulp_u));
            }else{
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u , size.get(ulp_v) + size.get(ulp_u));
            }
        }
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DS ds = new DS(n*n);
        int[][] directions = {{-1,0},{0,-1},{0,1},{1,0}};

        for(int row =0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col] == 0) continue;

                for(int[] dir: directions){
                    int newr = row+dir[0];
                    int newc = col+ dir[1];

                    if(isValid(newr , newc , n) && grid[newr][newc]==1){
                        int nodeNo = row*n + col;
                        int adjNodeNo = newr*n+newc;
                        ds.unionBySize(nodeNo , adjNodeNo);
                    }
                }
            }
        }

        int max =0;
        for(int row =0;row<n;row++){
            for(int col =0;col<n;col++){
                if(grid[row][col] == 1) continue;

                HashSet<Integer> comp = new HashSet<>();

                for(int[] dir: directions){
                    int newr = row + dir[0];
                    int newc = col + dir[1];

                    if(isValid(newr, newc , n) && grid[newr][newc] == 1){
                        comp.add(ds.findUPar(newr*n+newc));
                    }
                }
                int sizeTotal = 0;
                for(Integer parent:comp){
                    sizeTotal+=ds.size.get(parent);
                }
                max = Math.max(max , sizeTotal+1);
            }
        }
        for(int cellNo =0 ;cellNo<n*n ;cellNo ++){
            max = Math.max(max , ds.size.get(ds.findUPar(cellNo)));
        }
        return max;
        
    }

    boolean isValid(int row , int col , int n){
        return row>=0 && row<n && col< n && col>=0;
    }
}