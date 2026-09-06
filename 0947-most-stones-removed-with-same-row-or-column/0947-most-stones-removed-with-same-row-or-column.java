class Solution {
    class DisjointSet{
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        
        public DisjointSet(int n){
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

            if(size.get(ulp_u) < size.get(ulp_v)){
                parent.set(ulp_u , ulp_v);
                size.set(ulp_v , size.get(ulp_u)+size.get(ulp_v));
            }else{
                parent.set(ulp_v , ulp_u);
                size.set(ulp_u , size.get(ulp_v) + size.get(ulp_u));
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow =0;
        int maxCol = 0;
        for(int i =0;i<n;i++){
            maxRow = Math.max(maxRow , stones[i][0]);
            maxCol = Math.max(maxCol , stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow+maxCol+2);
        HashMap<Integer , Integer> stoneNode = new HashMap<>();
        for(int i =0;i<n;i++){
            int newR = stones[i][0];
            int newC = stones[i][1] + maxRow +1;
            ds.unionBySize(newR , newC);
        }

        int component =0;
        for(int i =0;i<maxRow+maxCol+2;i++){
            if(ds.parent.get(i) == i && ds.size.get(i)>1) component++;
        }
        return n-component;
    }
}