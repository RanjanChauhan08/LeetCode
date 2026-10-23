class Solution {
    public boolean helper(int[][]graph,int[]visited,int[]pathVisited,int node,int[]check){
        visited[node]=1;
        pathVisited[node]=1;
        check[node]=0;
        for(Integer i:graph[node]){
            if(visited[i]==0){
                boolean bt=helper(graph,visited,pathVisited,i,check);
                if(bt)return true;
            }
            else if(pathVisited[i]==1){
                return true;
            }
        }
        check[node]=1;
        pathVisited[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer>ans=new ArrayList<>();
        int[]visited=new int[graph.length];
        int[]pathVisited=new int[graph.length];
        int[]check=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(visited[i]==0){
                boolean bt=helper(graph,visited,pathVisited,i,check);
            }
        }
        for(int i=0;i<graph.length;i++){
            if(check[i]==1){
                ans.add(i);
            }
        }
        return ans;
    }
}