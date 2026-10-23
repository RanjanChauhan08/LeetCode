class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>>adj,int[]visited,int[]pathVisited,List<Integer>ans,int a){
        pathVisited[a]=1;
        visited[a]=1;
        for(int i=0;i<adj.get(a).size();i++){
            int b=adj.get(a).get(i);
            if(visited[b]==0){
                if(dfs(adj,visited,pathVisited,ans,b))return true;
            }
            else if(pathVisited[b]==1){
                return true;
            }
        }
        ans.add(a);
        pathVisited[a]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        List<Integer>ans=new ArrayList<>();
        int[]visited=new int[graph.length];
        int[]pathVisited=new int[graph.length];
        for(int i=0;i<visited.length;i++){
            if(visited[i]==0){
                dfs(adj,visited,pathVisited,ans,i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}