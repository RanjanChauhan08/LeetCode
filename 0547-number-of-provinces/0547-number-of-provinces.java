class Solution {
    public void dfs(int[][]isConnected,int node,int[]visited){
        visited[node]=1;
        for(int i=0;i<isConnected.length;i++){
            int c=isConnected[node-1][i];
            if(c==1 && visited[i+1]==0){
                dfs(isConnected,i+1,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int[]visited=new int[isConnected.length+1];
        int ans=0;
        for(int i=1;i<visited.length;i++){
            if(visited[i]==0){
                ans++;
                dfs(isConnected,i,visited);
            }
        }
        return ans;
    }
}