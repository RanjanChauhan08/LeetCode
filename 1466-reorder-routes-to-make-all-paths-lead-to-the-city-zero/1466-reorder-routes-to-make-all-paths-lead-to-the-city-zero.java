class Solution {
    public void dfs(int node,ArrayList<ArrayList<Integer>>adj,ArrayList<ArrayList<Integer>>adjRev,Set<Integer>set,int n,int[]ans){
        set.add(node);
        if(set.size()>=n)return;
        for(Integer newNode:adj.get(node)){
            if(!set.contains(newNode)){
                dfs(newNode,adj,adjRev,set,n,ans);
            }
        }
        for(int i=0;i<adjRev.get(node).size();i++){
            int newNode=adjRev.get(node).get(i);
            if(!set.contains(newNode)){
                ans[0]++;
                dfs(newNode,adj,adjRev,set,n,ans);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        Set<Integer>set=new HashSet<>();
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        ArrayList<ArrayList<Integer>>adjRev=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            adjRev.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            adj.get(v).add(u);
            adjRev.get(u).add(v);
        }
        int[]ans={0};
        dfs(0,adj,adjRev,set,n,ans);
        return ans[0];
    }
}