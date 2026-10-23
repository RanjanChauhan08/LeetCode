class Solution {
    public boolean dfs(int a,int[]pathVisited,int[]visited,ArrayList<ArrayList<Integer>>adj){
        visited[a]=1;
        pathVisited[a]=1;
        for(int i=0;i<adj.get(a).size();i++){
            int b=adj.get(a).get(i);
            if(visited[b]==0){
                if(dfs(b,pathVisited,visited,adj))return true;
            }
            else if(pathVisited[b]==1)return true;
        }
        pathVisited[a]=0;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
        }
        int[]visited=new int[V];
        int[]pathVisited=new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(dfs(i,pathVisited,visited,adj))return true;
            }
        }
        return false;
    }
}