class Solution {
    public void dfs(ArrayList<ArrayList<Integer>>adj,int[]nodes,int node,int[]visited,Set<Integer>set){
        visited[node]=1;
        nodes[0]++;
        set.add(node);
        for(int i=0;i<adj.get(node).size();i++){
            int newNode=adj.get(node).get(i);
            if(visited[newNode]==1)continue;
            dfs(adj,nodes,newNode,visited,set);
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        int[]visited=new int[n];
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Set<Integer>set=new HashSet<>();
        int ans=0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                int[]nodes={0};
                dfs(adj,nodes,i,visited,set);
                boolean bt=true;
                for(Integer x:set){
                    if(adj.get(x).size()<nodes[0]-1)bt=false;
                }
                if(bt){
                    ans++;
                }
                set.clear();
            }
        }
        return ans;
    }
}